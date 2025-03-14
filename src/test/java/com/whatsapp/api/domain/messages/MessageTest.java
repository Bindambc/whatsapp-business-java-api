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

    @Test
    public void testComponentWithNamedAndOrderedParameters() {
        // Create named parameters
        TextParameter namedParam1 = new TextParameter("John");
        namedParam1.setParameterName("customer_name");

        TextParameter namedParam2 = new TextParameter("9128312831");
        namedParam2.setParameterName("order_id");

        // Create ordered parameters
        TextParameter orderedParam1 = new TextParameter("John");
        TextParameter orderedParam2 = new TextParameter("9128312831");

        // Create a component and add parameters
        Component<?> component = new BodyComponent();
        component.addParameter(namedParam1)
                .addParameter(namedParam2)
                .addParameter(orderedParam1)
                .addParameter(orderedParam2);

        // Verify named parameters
        assertEquals("customer_name", component.getParameters().get(0).getParameterName());
        assertEquals("John", ((TextParameter) component.getParameters().get(0)).getText());

        assertEquals("order_id", component.getParameters().get(1).getParameterName());
        assertEquals("9128312831", ((TextParameter) component.getParameters().get(1)).getText());

        // Verify ordered parameters
        assertEquals(null, component.getParameters().get(2).getParameterName());
        assertEquals("John", ((TextParameter) component.getParameters().get(2)).getText());

        assertEquals(null, component.getParameters().get(3).getParameterName());
        assertEquals("9128312831", ((TextParameter) component.getParameters().get(3)).getText());
    }
}
