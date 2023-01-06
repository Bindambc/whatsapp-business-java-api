package com.whatsapp.api.domain.webhook.cloudapi;

import com.whatsapp.api.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

class WebHookPayloadTest extends TestUtils {

    private final String JSON_FOLDER = "/deserialization/";

    @Test
    void testDeserializationTextMessage() throws IOException, URISyntaxException {
        var fileContent = fromResource(JSON_FOLDER + "textMessage.json");

        var obj = objectMapper.readValue(fileContent, WebHookPayload.class);

        Assertions.assertNotNull(obj);
        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals("messages", obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals("hi everyone!", obj.entry().get(0).changes().get(0).value().messages().get(0).text().body());
        Assertions.assertEquals("text", obj.entry().get(0).changes().get(0).value().messages().get(0).type());


    }

    @Test
    void testDeserializationTextMessage2() throws IOException, URISyntaxException {
        var fileContent = fromResource(JSON_FOLDER + "textMessage2.json");

        var obj = objectMapper.readValue(fileContent, WebHookPayload.class);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().contacts().isEmpty());

        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals("messages", obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals("Good afternoon", obj.entry().get(0).changes().get(0).value().messages().get(0).text().body());
        Assertions.assertEquals("text", obj.entry().get(0).changes().get(0).value().messages().get(0).type());


    }

    @Test
    void testDeserializationTextMessageSent() throws IOException, URISyntaxException {
        var fileContent = fromResource(JSON_FOLDER + "textMessageStatusSent.json");

        var obj = objectMapper.readValue(fileContent, WebHookPayload.class);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry());
        Assertions.assertFalse(obj.entry().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0));
        Assertions.assertNotNull(obj.entry().get(0).changes());
        Assertions.assertFalse(obj.entry().get(0).changes().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).field());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().statuses());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().statuses().isEmpty());


        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals("messages", obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals("sent", obj.entry().get(0).changes().get(0).value().statuses().get(0).status());


    }

    @Test
    void testDeserializationTextMessageDelivered() throws IOException, URISyntaxException {
        var fileContent = fromResource(JSON_FOLDER + "textMessageStatusDelivered.json");

        var obj = objectMapper.readValue(fileContent, WebHookPayload.class);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry());
        Assertions.assertFalse(obj.entry().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0));
        Assertions.assertNotNull(obj.entry().get(0).changes());
        Assertions.assertFalse(obj.entry().get(0).changes().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).field());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().statuses());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().statuses().isEmpty());


        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals("messages", obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals("delivered", obj.entry().get(0).changes().get(0).value().statuses().get(0).status());


    }

    @Test
    void testDeserializationTextMessageRead() throws IOException, URISyntaxException {
        var fileContent = fromResource(JSON_FOLDER + "textMessageStatusRead.json");

        var obj = objectMapper.readValue(fileContent, WebHookPayload.class);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry());
        Assertions.assertFalse(obj.entry().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0));
        Assertions.assertNotNull(obj.entry().get(0).changes());
        Assertions.assertFalse(obj.entry().get(0).changes().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).field());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().statuses());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().statuses().isEmpty());


        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals("messages", obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals("read", obj.entry().get(0).changes().get(0).value().statuses().get(0).status());


    }


}

