package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.MessageType;

import java.util.List;

/**
 * To send a message, you must first assemble a message object with the content you want to send.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    @JsonProperty("messaging_product")
    private final String messagingProduct = "whatsapp";
    @JsonProperty("recipient_type")
    private final String recipientType = "individual";
    /**
     * The Interactive message.
     */
    @JsonProperty("interactive")
    public InteractiveMessage interactiveMessage;
    @JsonProperty("to")
    private String to;
    @JsonProperty("type")
    private MessageType type;
    @JsonProperty("text")
    private TextMessage textMessage;
    @JsonProperty("contacts")
    private List<Contact> contactMessage;
    @JsonProperty("template")
    private TemplateMessage templateMessage;


    private Message() {
    }

    private Message(String to, MessageType type) {
        this.to = to;
        this.type = type;
    }

    /**
     * Gets messaging product.
     *
     * @return the messaging product
     */
    public String getMessagingProduct() {
        return messagingProduct;
    }

    /**
     * Gets recipient type.
     *
     * @return the recipient type
     */
    public String getRecipientType() {
        return recipientType;
    }

    /**
     * The type Message builder.
     */
    public static class MessageBuilder {

        private String to;


        private MessageBuilder() {
        }

        /**
         * Builder message builder.
         *
         * @return the message builder
         */
        public static MessageBuilder builder() {
            return new MessageBuilder();
        }

        /**
         * Sets to.
         *
         * @param to Required.           <p>           WhatsApp ID or phone number for the person you want to send a message to.
         * @return the to
         */
        public MessageBuilder setTo(String to) {
            this.to = to;
            return this;
        }

        /**
         * Build a text objetc, with:
         * <ul>
         *     <li><b>body</b> required</li>
         *     <li><b>preview_url</b> optional</li>
         * </ul>
         *
         * @param textMessage : {@link TextMessage} object.
         * @return the message
         */
        public Message buildTextMessage(TextMessage textMessage) {
            var message = new Message(to, MessageType.TEXT);
            message.textMessage = textMessage;
            return message;


        }

        /**
         * <b>Required</b>.
         * Build an objetc with {@link Contact}
         *
         * @param contactMessage the contact message
         * @return the message
         */
        public Message buildContactMessage(ContactMessage contactMessage) {
            var message = new Message(to, MessageType.CONTACTS);
            message.contactMessage = contactMessage.getContacts();
            return message;

        }

        /**
         * Build template message message.
         *
         * @param templateMessage the template message
         * @return the message
         */
        public Message buildTemplateMessage(TemplateMessage templateMessage) {
            var message = new Message(to, MessageType.TEMPLATE);
            message.templateMessage = templateMessage;
            return message;

        }

        /**
         * Build an object to send an {@link InteractiveMessage}
         *
         * @param interactiveMessage the interactive message
         * @return the message
         */
        public Message buildInteractiveMessage(InteractiveMessage interactiveMessage) {
            var message = new Message(to, MessageType.INTERACTIVE);
            message.interactiveMessage = interactiveMessage;
            return message;

        }


    }

}

