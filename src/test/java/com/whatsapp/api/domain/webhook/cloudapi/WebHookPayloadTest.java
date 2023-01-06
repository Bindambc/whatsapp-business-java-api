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

    @Test
    void testDeserializationButtonMessage() throws IOException, URISyntaxException {
        var fileContent = fromResource(JSON_FOLDER + "buttonMessage.json");

        var obj = objectMapper.readValue(fileContent, WebHookPayload.class);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().contacts().isEmpty());

        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals("messages", obj.entry().get(0).changes().get(0).field());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).context());
        Assertions.assertEquals("button", obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).button());

    }


    @Test
    void testDeserializationMessageDeleted() throws IOException, URISyntaxException {
        var fileContent = fromResource(JSON_FOLDER + "messageDeleted.json");

        var obj = objectMapper.readValue(fileContent, WebHookPayload.class);

        Assertions.assertNotNull(obj);
        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().contacts().isEmpty());


        Assertions.assertEquals("unsupported", obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).errors());


    }

    @Test
    void testDeserializationReactMessage() throws IOException, URISyntaxException {
        var fileContent = fromResource(JSON_FOLDER + "reactMessage.json");

        var obj = objectMapper.readValue(fileContent, WebHookPayload.class);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().contacts().isEmpty());

        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals("messages", obj.entry().get(0).changes().get(0).field());

        Assertions.assertEquals("reaction", obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).reaction());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).reaction().messageId());

    }


    @Test
    void testDeserializationStickerMessage() throws IOException, URISyntaxException {
        var fileContent = fromResource(JSON_FOLDER + "stickerMessage.json");

        var obj = objectMapper.readValue(fileContent, WebHookPayload.class);

        Assertions.assertEquals("whatsapp_business_account", obj.object());
        Assertions.assertFalse(obj.entry().isEmpty());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());

        Assertions.assertFalse(obj.entry().get(0).changes().isEmpty());

        Assertions.assertEquals("sticker", obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertEquals("image/webp", obj.entry().get(0).changes().get(0).value().messages().get(0).sticker().mimeType());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().messages().get(0).sticker().animated());
        Assertions.assertEquals("1604825680670873", obj.entry().get(0).changes().get(0).value().messages().get(0).sticker().id());

    }


}

