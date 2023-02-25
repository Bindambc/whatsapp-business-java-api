package com.whatsapp.api.impl;

import com.whatsapp.api.MockServerUtilsTest;
import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.media.FileType;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.TextMessage;
import com.whatsapp.api.exception.WhatsappApiException;
import com.whatsapp.api.exception.utils.Formatter;
import mockwebserver3.MockResponse;
import mockwebserver3.RecordedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.configuration.WhatsappApiConfig.API_VERSION;

public class WhatsappBusinessCloudApiTest extends MockServerUtilsTest {


    @Test
    void testSendTextMessage() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/message.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTextMessage(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false));


        var response = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/messages", recordedRequest.getPath());

        Assertions.assertEquals("wamid.gBGGSFcCNEOPAgkO_KJ55r4w_ww", response.messages().get(0).id());
    }

    @Test
    void testUploadMedia() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/uploadResponse.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

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

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();


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

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

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

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var exception = Assertions.assertThrows(WhatsappApiException.class, () -> whatsappBusinessCloudApi.downloadMediaFile(baseUrl + "/whatsapp_business/attachments/?mid=1228169767822607&ext=16772107977&hash=ATs5BiSbLTZzCFh73M16stmnUK2UV6NBqChXB4WWC21sw"));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/whatsapp_business/attachments/?mid=1228169767822607&ext=16772107977&hash=ATs5BiSbLTZzCFh73M16stmnUK2UV6NBqChXB4WWC21sw", recordedRequest.getPath());

        Assertions.assertEquals("Not found", exception.getMessage());

    }

    @Test
    void testDeleteMedia() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/reponse.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();


        var response = whatsappBusinessCloudApi.deleteMedia("1227829768162607");

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("DELETE", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + "1227829768162607", recordedRequest.getPath());

        Assertions.assertTrue(response.success());

    }


}

