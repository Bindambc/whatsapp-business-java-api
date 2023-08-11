package com.whatsapp.api.impl;

import com.whatsapp.api.MockServerUtilsTest;
import com.whatsapp.api.domain.media.FileType;
import com.whatsapp.api.domain.messages.Action;
import com.whatsapp.api.domain.messages.Address;
import com.whatsapp.api.domain.messages.AudioMessage;
import com.whatsapp.api.domain.messages.Body;
import com.whatsapp.api.domain.messages.BodyComponent;
import com.whatsapp.api.domain.messages.Button;
import com.whatsapp.api.domain.messages.ButtonComponent;
import com.whatsapp.api.domain.messages.ButtonPayloadParameter;
import com.whatsapp.api.domain.messages.ButtonTextParameter;
import com.whatsapp.api.domain.messages.Contact;
import com.whatsapp.api.domain.messages.ContactMessage;
import com.whatsapp.api.domain.messages.Currency;
import com.whatsapp.api.domain.messages.CurrencyParameter;
import com.whatsapp.api.domain.messages.DateTime;
import com.whatsapp.api.domain.messages.DateTimeParameter;
import com.whatsapp.api.domain.messages.Document;
import com.whatsapp.api.domain.messages.DocumentMessage;
import com.whatsapp.api.domain.messages.DocumentParameter;
import com.whatsapp.api.domain.messages.Email;
import com.whatsapp.api.domain.messages.Footer;
import com.whatsapp.api.domain.messages.Header;
import com.whatsapp.api.domain.messages.HeaderComponent;
import com.whatsapp.api.domain.messages.Image;
import com.whatsapp.api.domain.messages.ImageMessage;
import com.whatsapp.api.domain.messages.ImageParameter;
import com.whatsapp.api.domain.messages.InteractiveMessage;
import com.whatsapp.api.domain.messages.Language;
import com.whatsapp.api.domain.messages.LocationMessage;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.Name;
import com.whatsapp.api.domain.messages.Org;
import com.whatsapp.api.domain.messages.Phone;
import com.whatsapp.api.domain.messages.ReactionMessage;
import com.whatsapp.api.domain.messages.ReadMessage;
import com.whatsapp.api.domain.messages.Reply;
import com.whatsapp.api.domain.messages.Row;
import com.whatsapp.api.domain.messages.Section;
import com.whatsapp.api.domain.messages.StickerMessage;
import com.whatsapp.api.domain.messages.TemplateMessage;
import com.whatsapp.api.domain.messages.TextMessage;
import com.whatsapp.api.domain.messages.TextParameter;
import com.whatsapp.api.domain.messages.Url;
import com.whatsapp.api.domain.messages.Video;
import com.whatsapp.api.domain.messages.VideoMessage;
import com.whatsapp.api.domain.messages.VideoParameter;
import com.whatsapp.api.domain.messages.type.AddressType;
import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.messages.type.ButtonType;
import com.whatsapp.api.domain.messages.type.CalendarType;
import com.whatsapp.api.domain.messages.type.EmailType;
import com.whatsapp.api.domain.messages.type.HeaderType;
import com.whatsapp.api.domain.messages.type.InteractiveMessageType;
import com.whatsapp.api.domain.messages.type.PhoneType;
import com.whatsapp.api.domain.messages.type.UrlType;
import com.whatsapp.api.domain.phone.TwoStepCode;
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
    void testSendContactMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage10.json");

        var contactMessage = new ContactMessage()//
                .addContacts(new Contact()//
                                .addPhones(new Phone()//
                                        .setPhone(PHONE_NUMBER_1)//
                                        .setType(PhoneType.IPHONE))//
                                .setName(new Name()//
                                        .setFormattedName("Mauricio Binda")////
                                        .setFirstName("Mauricio"))//
                                .setOrg(new Org()//
                                        .setTitle("Org title")//
                                        .setCompany("My company")//
                                        .setDepartment("IT"))//
                                .addEmails(new Email()//
                                        .setType(EmailType.HOME)//
                                        .setEmail("mauriciobinda@hotmail.com")//
                                ).addAddresses(new Address()//
                                        .setCity("New York")//
                                        .setCountry("United States")//
                                        .setState("NY")//
                                        .setType(AddressType.WORK)//
                                        .setStreet("47 W 13th St")//
                                        .setZip("10011")//
                                        .setCountryCode("US")//
                                ).setBirthday("1900-01-01").addUrls(new Url()//
                                        .setType(UrlType.WORK)//
                                        .setUrl("https://www.google.com")//
                                )

                        //
                );

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildContactMessage(contactMessage);


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());
        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testSendContactMessage2() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage10.json");

        var contactMessage = new ContactMessage()//
                .addContacts(new Contact()//
                                .addPhone(new Phone()//
                                        .setPhone(PHONE_NUMBER_1)//
                                        .setType(PhoneType.IPHONE))//
                                .setName(new Name()//
                                        .setFormattedName("Mauricio Binda")////
                                        .setFirstName("Mauricio"))//
                                .setOrg(new Org()//
                                        .setTitle("Org title")//
                                        .setCompany("My company")//
                                        .setDepartment("IT"))//
                                .addEmail(new Email()//
                                        .setType(EmailType.HOME)//
                                        .setEmail("mauriciobinda@hotmail.com")//
                                ).addAddress(new Address()//
                                        .setCity("New York")//
                                        .setCountry("United States")//
                                        .setState("NY")//
                                        .setType(AddressType.WORK)//
                                        .setStreet("47 W 13th St")//
                                        .setZip("10011")//
                                        .setCountryCode("US")//
                                ).setBirthday("1900-01-01").addUrl(new Url()//
                                        .setType(UrlType.WORK)//
                                        .setUrl("https://www.google.com")//
                                )

                        //
                );

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildContactMessage(contactMessage);


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

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }


    @Test
    void testSendTemplateButtonMessageMarketing() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage5.json");

        var templateMessage = new TemplateMessage()//
                .setLanguage(new Language(LanguageType.EN_US))//
                .setName("marketing_music_2")//
                .addComponent(new HeaderComponent()//
                        .addParameter(new ImageParameter()//
                                .setImage(new Image()//
                                        .setId("3196424913981611")//
                                ))).addComponent(//
                        new BodyComponent()//
                                .addParameter(new DateTimeParameter()//
                                        .setDateTime(new DateTime()//
                                                .setCalendar(CalendarType.GREGORIAN)//
                                                .setDayOfMonth(26)//
                                                .setMonth(3)//
                                                .setYear(2023)//
                                                .setHour(10).setMinute(50).setDayOfWeek(1).setFallbackValue("May 10th, 2023")//
                                        ))//
                                .addParameter(new CurrencyParameter()//
                                        .setCurrency(new Currency("$35", "USD", 30000))))//

                .addComponent(new ButtonComponent()//
                        .setIndex(0)//
                        .setSubType(ButtonSubType.QUICK_REPLY)//
                        .addParameter(new ButtonPayloadParameter("OP_SHN_454584")))//
                .addComponent(new ButtonComponent()//
                        .setIndex(1)//
                        .setSubType(ButtonSubType.QUICK_REPLY)//
                        .addParameter(new ButtonPayloadParameter("OP_SPR_454585")));


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
    void testSendTemplateDocumentPdfMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage6.json");

        var templateMessage = new TemplateMessage()//
                .setLanguage(new Language(LanguageType.EN_US))//
                .setName("new_classes_pdf")//
                .addComponent(new HeaderComponent()//
                        .addParameter(new DocumentParameter()//
                                .setDocument(new Document()//
                                        .setFileName("Class.pdf").setId("928860901494862")//
                                ))//
                ).addComponent(//
                        new BodyComponent()//
                                .addParameter(new TextParameter("Mauricio Binda")))//
                .addComponent(new ButtonComponent()//
                        .setIndex(0)//
                        .setSubType(ButtonSubType.URL)//
                        .addParameter(new ButtonTextParameter("career-academy/?trk_ref=globalnav")));


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
    void testSendTemplateVideoMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage8.json");

        var templateMessage = new TemplateMessage()//
                .setLanguage(new Language(LanguageType.EN_US))//
                .setName("video_tm")//
                .addComponent(new HeaderComponent()//
                        .addParameter(new VideoParameter()//
                                .setVideo(new Video()//
                                        .setId("4548775454857854")))//
                ).addComponent(//
                        new BodyComponent()//
                                .addParameter(new TextParameter("Mauricio Binda")))//
                ;


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
    void testSendTemplateAuthMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage9.json");

        var templateMessage = new TemplateMessage()//
                .setLanguage(new Language(LanguageType.PT_BR))//
                .setName("auth_app")//
                .addComponent(new HeaderComponent()//
                        .addParameter(new ImageParameter()//
                                .setImage(new Image("554066036582230", null)))

                ).addComponent(//
                        new BodyComponent()//
                                .addParameter(new TextParameter("T87-G74-876")));//


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
    void testSendAudioMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage7.json");

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildAudioMessage(new AudioMessage()//
                        .setId("4545454545454"));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testSendAudioLinkMessage() throws InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = """
                {
                    "messaging_product": "whatsapp",
                    "recipient_type": "individual",
                    "to": "121212121212",
                    "type": "audio",
                    "audio": {
                        "link": "https://testeteste778787878.com/audio.mp3"
                    }
                }
                """;

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildAudioMessage(new AudioMessage()//
                        .setLink("https://testeteste778787878.com/audio.mp3"));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());
        //

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);


        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testSendVideoMessage() throws InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = """
                {
                    "messaging_product": "whatsapp",
                    "recipient_type": "individual",
                    "to": "121212121212",
                    "type": "video",
                    "video": {
                        "id": "78795489879879554",
                        "caption": "See the video"
                    }
                }
                """;

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildVideoMessage(new VideoMessage()//
                        .setId("78795489879879554")//
                        .setCaption("See the video"));


        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendImageMessage() throws InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = """
                {
                    "messaging_product": "whatsapp",
                    "recipient_type": "individual",
                    "to": "121212121212",
                    "type": "image",
                    "image": {
                        "id": "75457812459735784",
                        "caption": "See the image"
                    }
                }
                """;
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildImageMessage(new ImageMessage()//
                        .setId("75457812459735784")//
                        .setCaption("See the image"));


        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);
    }

    @Test
    void testSendDocumentMessage() throws InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = """
                {
                    "messaging_product": "whatsapp",
                    "recipient_type": "individual",
                    "to": "121212121212",
                    "type": "document",
                    "document": {
                        "id": "78548846588564",
                        "caption": "My document",
                        "filename": "test.pdf"
                    }
                }
                """;
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildDocumentMessage(new DocumentMessage()//
                        .setId("78548846588564")//
                        .setFileName("test.pdf").setCaption("My document"));

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);


    }

    @Test
    void testSendStickerMessage() throws InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = """
                {
                    "messaging_product": "whatsapp",
                    "recipient_type": "individual",
                    "to": "121212121212",
                    "type": "sticker",
                    "sticker": {
                        "id": "78548846588564"
                    }
                }
                """;

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildStickerMessage(new StickerMessage()//
                        .setId("78548846588564"));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
        Assertions.assertNotNull(response);
        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendInteractiveMessageWithButtons() throws InterruptedException, JSONException, IOException, URISyntaxException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage11.json");

        var interactive = InteractiveMessage.build() //
                .setAction(new Action() //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278454") //
                                        .setTitle("YES"))) //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278455") //
                                        .setTitle("NO"))) //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278456") //
                                        .setTitle("CHANGE")))) //
                .setType(InteractiveMessageType.BUTTON) //
                .setHeader(new Header()//
                        .setType(HeaderType.TEXT)//
                        .setText("Appointment confirmation.")//

                ).setBody(new Body() //
                        .setText("Would you like to confirm your appointment for tomorrow?")) //
                .setFooter(new Footer().setText("Choose an option:"));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(interactive);


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
        Assertions.assertNotNull(response);
        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());
        //System.out.println(recordedRequest.getBody().readUtf8());
        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendInteractiveMessageWithImageHeader() throws InterruptedException, JSONException, IOException, URISyntaxException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage14.json");

        var interactive = InteractiveMessage.build() //
                .setAction(new Action() //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278454") //
                                        .setTitle("YES"))) //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278455") //
                                        .setTitle("NO"))) //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278456") //
                                        .setTitle("CHANGE")))) //
                .setType(InteractiveMessageType.BUTTON) //
                .setHeader(new Header()//
                        .setType(HeaderType.IMAGE)//
                        .setImage(new Image().setLink("https://upload.wikimedia.org/wikipedia/commons/8/87/Tamarama_Beach.jpg"))//
                ).setBody(new Body() //
                        .setText("Would you like to confirm your appointment for tomorrow?")) //
                .setFooter(new Footer().setText("Choose an option:"));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(interactive);


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
        Assertions.assertNotNull(response);
        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());
        // System.out.println(recordedRequest.getBody().readUtf8());
        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendInteractiveMessageWithVideoHeader() throws InterruptedException, JSONException, IOException, URISyntaxException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage15.json");

        var interactive = InteractiveMessage.build() //
                .setAction(new Action() //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278454") //
                                        .setTitle("YES"))) //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278455") //
                                        .setTitle("NO"))) //
                ) //
                .setType(InteractiveMessageType.BUTTON) //
                .setHeader(new Header()//
                        .setType(HeaderType.VIDEO)//
                        .setVideo(new Video().setLink("https://joy1.videvo.net/videvo_files/video/free/2014-04/large_watermarked/Lonely_tree_at_Sunset_slow_motion_CCBY_NatureClip_preview.mp4"))).setBody(new Body() //
                        .setText("Do you like this video?")) //
                .setFooter(new Footer().setText("Choose an option:"));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(interactive);


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
        Assertions.assertNotNull(response);
        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());
        //System.out.println(recordedRequest.getBody().readUtf8());
        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendInteractiveMessageWithDocumentHeader() throws InterruptedException, JSONException, IOException, URISyntaxException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage16.json");

        var interactive = InteractiveMessage.build() //
                .setAction(new Action() //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278454") //
                                        .setTitle("YES"))) //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278455") //
                                        .setTitle("NO"))) //
                        .addButton(new Button() //
                                .setType(ButtonType.REPLY).setReply(new Reply() //
                                        .setId("1278456") //
                                        .setTitle("CHANGE")))) //
                .setType(InteractiveMessageType.BUTTON) //
                .setHeader(new Header()//
                        .setType(HeaderType.DOCUMENT)//
                        .setDocument(new Document()//
                                .setFileName("schedule.pdf").setLink("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")))//
                .setBody(new Body() //
                        .setText("Would you like to confirm your appointment for tomorrow?")) //
                .setFooter(new Footer().setText("Choose an option:"));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(interactive);


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
        Assertions.assertNotNull(response);
        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());
        //System.out.println(recordedRequest.getBody().readUtf8());
        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendInteractiveMessageWithList() throws InterruptedException, JSONException, IOException, URISyntaxException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage12.json");

        var interactive = InteractiveMessage.build() //
                .setAction(new Action() //
                        .setButtonText("choose an option") //
                        .addSection(new Section() //
                                .setTitle("Section 1") //
                                .addRow(new Row() //
                                        .setId("SECTION_1_ROW_1_ID") //
                                        .setTitle("Title 1") //
                                        .setDescription("SECTION_1_ROW_1_DESCRIPTION")) //
                                .addRow(new Row() //
                                        .setId("SECTION_1_ROW_2_ID") //
                                        .setTitle("Title 2") //
                                        .setDescription("SECTION_1_ROW_2_DESCRIPTION")) //
                                .addRow(new Row() //
                                        .setId("SECTION_1_ROW_3_ID") //
                                        .setTitle("Title 3") //
                                        .setDescription("SECTION_1_ROW_3_DESCRIPTION")) //
                        ) //
                        .addSection(new Section() //
                                .setTitle("Section 2") //
                                .addRow(new Row() //
                                        .setId("SECTION_2_ROW_1_ID") //
                                        .setTitle("Title 1") //
                                        .setDescription("SECTION_2_ROW_1_DESCRIPTION")) //
                                .addRow(new Row() //
                                        .setId("SECTION_2_ROW_2_ID") //
                                        .setTitle("Title 2") //
                                        .setDescription("SECTION_2_ROW_2_DESCRIPTION")) //
                                .addRow(new Row() //
                                        .setId("SECTION_2_ROW_3_ID") //
                                        .setTitle("Title 3") //
                                        .setDescription("SECTION_2_ROW_3_DESCRIPTION")) //
                        )) //
                .setType(InteractiveMessageType.LIST) //
                .setHeader(new Header() //
                        .setType(HeaderType.TEXT) //
                        .setText("Header Text")) //
                .setBody(new Body() //
                        .setText("Body message")) //
                .setFooter(new Footer() //
                        .setText("Footer Text"));

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(interactive);

        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
        Assertions.assertNotNull(response);
        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendReactionMessage() throws InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));
        var emojiThumbsUp = "\uD83D\uDC4D";
        var expectedJson = """
                {
                    "messaging_product": "whatsapp",
                    "recipient_type": "individual",
                    "to": "121212121212",
                    "type": "reaction",
                    "reaction": {
                        "message_id": "wamid.HBgNNTUyNzk5NzAzMDkzNhUCABIYFDNBRjE2OTUyOTNCNTlCM0IzRDQ0AA==",
                        "emoji": "\\uD83D\\uDC4D"
                    }
                }
                """;

        var reactionMessage = new ReactionMessage()//
                .setMessageId("wamid.HBgNNTUyNzk5NzAzMDkzNhUCABIYFDNBRjE2OTUyOTNCNTlCM0IzRDQ0AA==")//
                .setEmoji(emojiThumbsUp);//

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildReactionMessage(reactionMessage);

        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
        Assertions.assertNotNull(response);
        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testSendReactionMessage2() throws InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));
        var emojiThumbsUp = "\uD83D\uDC4D";
        var expectedJson = """
                {
                    "messaging_product": "whatsapp",
                    "recipient_type": "individual",
                    "to": "121212121212",
                    "type": "reaction",
                    "reaction": {
                        "message_id": "wamid.HBgNNTUyNzk5NzAzMDkzNhUCABIYFDNBRjE2OTUyOTNCNTlCM0IzRDQ0AA==",
                        "emoji": "\\uD83D\\uDC4D"
                    }
                }
                """;

        var reactionMessage = new ReactionMessage("wamid.HBgNNTUyNzk5NzAzMDkzNhUCABIYFDNBRjE2OTUyOTNCNTlCM0IzRDQ0AA==", emojiThumbsUp);

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildReactionMessage(reactionMessage);

        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
        Assertions.assertNotNull(response);
        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    @Test
    void testUploadMedia() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/uploadResponse.json")));

        var fileContent = bytesFromResource("/starwars.png");


        var response = whatsappBusinessCloudApi.uploadMedia(PHONE_NUMBER_ID, "starwars.png", FileType.PNG, fileContent);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/media", recordedRequest.getPath());
        Assertions.assertEquals(103923, recordedRequest.getBodySize());
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

    @Test
    void testLocationMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_SEND_MESSAGE_RESPONSE));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage13.json");

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildLocationMessage(new LocationMessage()//
                        .setLatitude("39.284064")//
                        .setLongitude("-84.265742")//
                        .setName("Loveland Castle Museum")//
                        .setAddress("12025 Shore Dr, Loveland, OH 45140"));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testMarkAsReadMessage() throws IOException, URISyntaxException, InterruptedException, JSONException {

        String responseBody = """
                      {
                      "success": true
                }
                    """;
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(responseBody));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage17.json");

        var message = new ReadMessage("123456");

        var response = whatsappBusinessCloudApi.markMessageAsRead(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

        Assertions.assertTrue(response.success());
    }

    @Test
    void testTwoStepVerification() throws IOException, URISyntaxException, InterruptedException, JSONException {

        String responseBody = """
                     {
                      "success": true
                }
                    """;
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(responseBody));

        var expectedJson = fromResource(EXPECTED_FOLDER + "expectedMessage18.json");

        var twoStepCode = new TwoStepCode("123456");

        var response = whatsappBusinessCloudApi.twoStepVerification(PHONE_NUMBER_ID, twoStepCode);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID, recordedRequest.getPath());

        JSONAssert.assertEquals(expectedJson, recordedRequest.getBody().readUtf8(), JSONCompareMode.STRICT);

        Assertions.assertTrue(response.success());
    }

}
