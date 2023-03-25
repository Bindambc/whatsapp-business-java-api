package com.whatsapp.api.impl;

import com.whatsapp.api.MockServerUtilsTest;
import com.whatsapp.api.domain.media.FileType;
import com.whatsapp.api.domain.messages.AudioMessage;
import com.whatsapp.api.domain.messages.BodyComponent;
import com.whatsapp.api.domain.messages.ButtonComponent;
import com.whatsapp.api.domain.messages.ButtonPayloadParameter;
import com.whatsapp.api.domain.messages.DateTime;
import com.whatsapp.api.domain.messages.DateTimeParameter;
import com.whatsapp.api.domain.messages.DocumentMessage;
import com.whatsapp.api.domain.messages.ImageMessage;
import com.whatsapp.api.domain.messages.Language;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.StickerMessage;
import com.whatsapp.api.domain.messages.TemplateMessage;
import com.whatsapp.api.domain.messages.TextMessage;
import com.whatsapp.api.domain.messages.TextParameter;
import com.whatsapp.api.domain.messages.VideoMessage;
import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.messages.type.CalendarType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.exception.WhatsappApiException;
import com.whatsapp.api.utils.Formatter;
import mockwebserver3.MockResponse;
import mockwebserver3.RecordedRequest;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.whatsapp.api.configuration.WhatsappApiConfig.API_VERSION;

public class WhatsappBusinessCloudApiTest extends MockServerUtilsTest {

    private final String PHONE_NUMBER_1 = "121212121212";
    private final String PHONE_NUMBER_ID = "888888888888";

    private final String EXPECTED_FOLDER = "/expected/message/";

    private final String DEFAULT_SEND_MESSAGE_RESPONSE = """
            {
              "messaging_product": "whatsapp",
              "contacts": [
                {
                  "input": "48XXXXXXXXX",
                  "wa_id": "48XXXXXXXXX "
                }
              ],
              "messages": [
                {
                  "id": "wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww"
                }
              ]
            }
            """;

    @Test
    void testSendMessageError() throws InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(500).setBody("{" +//
                "  \"error\": {\n" +//
                "    \"message\": \"(#130429) Rate limit hit\",\n" +//
                "    \"type\": \"OAuthException\",\n" +//
                "    \"code\": 130429,\n" +//
                "    \"error_data\": {\n" +//
                "        \"messaging_product\": \"whatsapp\", \n" +//
                "        \"details\": \"Message failed to send because there were too many messages sent from this phone number in a short period of time\"\n" +//
                "    },\n" +//
                "    \"error_subcode\": 2494055,\n" +//
                "    \"fbtrace_id\": \"Az8or2yhqkZfEZ-_4Qn_Bam\"\n" +//
                "  }\n" +//
                "}"));


        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTextMessage(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false));


        var ex = Assertions.assertThrows(WhatsappApiException.class, () -> whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"messaging_product\":\"whatsapp\",\"recipient_type\":\"individual\",\"to\":\"%s\",\"type\":\"text\",\"text\":{\"preview_url\":false,\"body\":\"*Hello world!*\\nSome code here: \\n```hello world code here```\"}}", PHONE_NUMBER_1), recordedRequest.getBody().readUtf8());


        Assertions.assertEquals("[130429] (#130429) Rate limit hit | Message failed to send because there were too many messages sent from this phone number in a short period of time", ex.getMessage());
    }

    @Test
    void testSendTextMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage1.json");

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTextMessage(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testSendTemplateTextMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage2.json");

        var templateMessage = new TemplateMessage()//
                .setLanguage(new Language(LanguageType.PT_BR))//
                .setName("number_confirmation")//
                .addComponent(new BodyComponent().addParameter(new TextParameter("18754269072")));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(templateMessage);

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendTemplateButtonMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage3.json");

        var templateMessage = new TemplateMessage()//
                .setLanguage(new Language(LanguageType.PT_BR))//
                .setName("schedule_confirmation3")//
                .addComponent(new BodyComponent()//
                        .addParameter(new TextParameter("Mauricio"))//
                        .addParameter(new TextParameter("04/11/2022"))//
                        .addParameter(new TextParameter("14:30")))//
                .addComponent(new ButtonComponent()//
                        .setIndex(0)//
                        .setSubType(ButtonSubType.QUICK_REPLY)//
                        .addParameter(new ButtonPayloadParameter("OP_YES_48547")))//
                .addComponent(new ButtonComponent()//
                        .setIndex(1)//
                        .setSubType(ButtonSubType.QUICK_REPLY)//
                        .addParameter(new ButtonPayloadParameter("OP_NO_48548")))//
                .addComponent(new ButtonComponent(2, ButtonSubType.QUICK_REPLY)//
                        .addParameter(new ButtonPayloadParameter("OP_CH_48549")));


        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(templateMessage);

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());
        // System.out.println(recordedRequest.getBody().readUtf8());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendTemplateButtonMessageWithDateTimeParam() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage4.json");

        var templateMessage = new TemplateMessage()//
                .setLanguage(new Language(LanguageType.PT_BR))//
                .setName("schedule_confirmation3")//
                .addComponent(new BodyComponent()//
                        .addParameter(new TextParameter("Mauricio"))//
                        .addParameter(new DateTimeParameter()//
                                .setDateTime(new DateTime()//
                                        .setCalendar(CalendarType.GREGORIAN)//
                                        .setDayOfMonth(25)//
                                        .setMonth(3)//
                                        .setYear(2023)//
                                        .setHour(13).setMinute(50).setDayOfWeek(7).setFallbackValue("25/03/2023")//
                                ))//
                        .addParameter(new DateTimeParameter()//
                                .setDateTime(new DateTime()//
                                        .setHour(14)//
                                        .setMinute(30)//
                                        .setFallbackValue("14:34")//
                                )))//

                .addComponent(new ButtonComponent()//
                        .setIndex(0)//
                        .setSubType(ButtonSubType.QUICK_REPLY)//
                        .addParameter(new ButtonPayloadParameter("OP_YES_48547")))//
                .addComponent(new ButtonComponent()//
                        .setIndex(1)//
                        .setSubType(ButtonSubType.QUICK_REPLY)//
                        .addParameter(new ButtonPayloadParameter("OP_NO_48548")))//
                .addComponent(new ButtonComponent(2, ButtonSubType.QUICK_REPLY)//
                        .addParameter(new ButtonPayloadParameter("OP_CH_48549")));


        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(templateMessage);

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());
        //System.out.println(recordedRequest.getBody().readUtf8());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }


    @Test
    void testSendAudioMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildAudioMessage(new AudioMessage()//
                        .setId("4545454545454"));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"messaging_product\":\"whatsapp\",\"recipient_type\":\"individual\",\"to\":\"%s\",\"type\":\"audio\",\"audio\":{\"id\":\"4545454545454\"}}", PHONE_NUMBER_1), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testSendAudioLinkMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var link = "https://testeteste778787878.com/audio.mp3";
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildAudioMessage(new AudioMessage()//
                        .setLink(link));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        Assertions.assertEquals(String.format("{\"messaging_product\":\"whatsapp\",\"recipient_type\":\"individual\",\"to\":\"%s\",\"type\":\"audio\",\"audio\":{\"link\":\"%s\"}}", PHONE_NUMBER_1, link), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testSendVideoMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildVideoMessage(new VideoMessage()//
                        .setId("78795489879879554")//
                        .setCaption("See the video"));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());


        Assertions.assertEquals(String.format("{\"messaging_product\":\"whatsapp\",\"recipient_type\":\"individual\",\"to\":\"%s\",\"type\":\"video\",\"video\":{\"id\":\"78795489879879554\",\"caption\":\"See the video\"}}", PHONE_NUMBER_1), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testSendImageMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildImageMessage(new ImageMessage()//
                        .setId("75457812459735784")//
                        .setCaption("See the image"));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());


        Assertions.assertEquals(String.format("{\"messaging_product\":\"whatsapp\",\"recipient_type\":\"individual\",\"to\":\"%s\",\"type\":\"image\",\"image\":{\"id\":\"75457812459735784\",\"caption\":\"See the image\"}}", PHONE_NUMBER_1), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testSendDocumentMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildDocumentMessage(new DocumentMessage()//
                        .setId("78548846588564")//
                        .setFileName("test.pdf").setCaption("My document"));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());


        Assertions.assertEquals(String.format("{\"messaging_product\":\"whatsapp\",\"recipient_type\":\"individual\",\"to\":\"%s\",\"type\":\"document\",\"document\":{\"id\":\"78548846588564\",\"caption\":\"My document\",\"filename\":\"test.pdf\"}}", PHONE_NUMBER_1), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testSendStickerMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildStickerMessage(new StickerMessage()//
                        .setId("78548846588564"));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());


        Assertions.assertEquals(String.format("{\"messaging_product\":\"whatsapp\",\"recipient_type\":\"individual\",\"to\":\"%s\",\"type\":\"sticker\",\"sticker\":{\"id\":\"78548846588564\"}}", PHONE_NUMBER_1), recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testUploadMedia() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/uploadResponse.json")));

        var fileContent = bytesFromResource("/starwars.png");


        var response = whatsappBusinessCloudApi.uploadMedia(PHONE_NUMBER_ID, "starwars.png", FileType.PNG, fileContent);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/media", recordedRequest.getPath());

        Assertions.assertEquals("985569392615996", response.id());
    }

    @Test
    void testRetrieveMediaUrl() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/media.json")));

        var response = whatsappBusinessCloudApi.retrieveMediaUrl("1227829768162607");

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + "1227829768162607", recordedRequest.getPath());

        Assertions.assertEquals("1227829768162607", response.id());
        Assertions.assertEquals(103632L, response.fileSize());
        Assertions.assertEquals(FileType.PNG, response.mimeType());
        Assertions.assertEquals("72fd8a734216768565faf2b59cec266eea00a78dd039ce84356319fc8c4ad22e", response.sha256());
        Assertions.assertEquals("https://lookaside.fbsbx.com/whatsapp_business/attachments/?mid=1228169767822607&ext=16772107977&hash=ATs5BiSbLTZzCFh73M16stmnUK2UV6NBqChXB4WWC21sw", response.url());

    }

    @Test
    void testDownloadMediaFile() throws InterruptedException, IOException, URISyntaxException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/starwars.png")).setResponseCode(200).addHeader("Content-Disposition", "inline;filename=starwars.png"));

        var response = whatsappBusinessCloudApi.downloadMediaFile(baseUrl + "/whatsapp_business/attachments/?mid=1228169767822607&ext=16772107977&hash=ATs5BiSbLTZzCFh73M16stmnUK2UV6NBqChXB4WWC21sw");

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/whatsapp_business/attachments/?mid=1228169767822607&ext=16772107977&hash=ATs5BiSbLTZzCFh73M16stmnUK2UV6NBqChXB4WWC21sw", recordedRequest.getPath());

        Assertions.assertEquals("starwars.png", response.fileName());
        Assertions.assertNotNull(response.content());
        Assertions.assertTrue(response.content().length > 0);

    }

    @Test
    void testDownloadMediaFileNotFound() throws InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("<html>.</html>").setResponseCode(404));

        var exception = Assertions.assertThrows(WhatsappApiException.class, () -> whatsappBusinessCloudApi.downloadMediaFile(baseUrl + "/whatsapp_business/attachments/?mid=1228169767822607&ext=16772107977&hash=ATs5BiSbLTZzCFh73M16stmnUK2UV6NBqChXB4WWC21sw"));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/whatsapp_business/attachments/?mid=1228169767822607&ext=16772107977&hash=ATs5BiSbLTZzCFh73M16stmnUK2UV6NBqChXB4WWC21sw", recordedRequest.getPath());

        Assertions.assertEquals("Not found", exception.getMessage());

    }

    @Test
    void testDeleteMedia() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/reponse.json")));

        var response = whatsappBusinessCloudApi.deleteMedia("1227829768162607");

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("DELETE", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + "1227829768162607", recordedRequest.getPath());

        Assertions.assertTrue(response.success());

    }


}

