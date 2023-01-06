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


}

