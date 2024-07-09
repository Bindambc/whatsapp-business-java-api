package com.whatsapp.api.domain.messages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    public void testMessageBuilderWithContext() {
        String messageId = "wamid.HBgNNTUyNzk5NzAzMDkzNhUCABIYFDNBRjE2OTUyOTNCNTlCM0IzRDQ0AA==";
        Context context = new Context();
        context.setMessageId(messageId);

        Message message = Message.MessageBuilder.builder()
                .setTo("123456789")
                .setContext(context)
                .buildTextMessage(new TextMessage());

        assertNotNull(message.getContext(), "Context should not be null");
        assertEquals(messageId, message.getContext().getMessageId(), "Context field value mismatch");
    }

    @Test
    public void testMessageWithoutContext() {
        Message message = Message.MessageBuilder.builder()
                .setTo("123456789")
                .buildTextMessage(new TextMessage());

        assertEquals(null, message.getContext(), "Context should be null");
    }
}
