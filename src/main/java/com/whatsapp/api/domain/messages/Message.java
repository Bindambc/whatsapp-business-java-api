package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty("interactive")
    public InteractiveMessage interactiveMessage;


    private Message() {
    }

    private Message(String to, MessageType type) {
        this.to = to;
        this.type = type;
    }

    public String getMessagingProduct() {
        return messagingProduct;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public static class MessageBuilder {

        private String to;


        private MessageBuilder() {
        }

        public static MessageBuilder builder() {
            return new MessageBuilder();
        }

        /**
         * @param to Required.
         *           <p>
         *           WhatsApp ID or phone number for the person you want to send a message to.
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
         * @param textMessage: {@link TextMessage} object.
         */
        public Message buildTextMessage(TextMessage textMessage) {
            var message = new Message(to, MessageType.TEXT);
            message.textMessage = textMessage;
            return message;


        }

        /**
         * <b>Requiered</b>.
         * Build an objetc with {@link Contact}
         */
        public Message buildContactMessage(ContactMessage contactMessage) {
            var message = new Message(to, MessageType.CONTACTS);
            message.contactMessage = contactMessage.getContacts();
            return message;

        }

        public Message buildTemplateMessage(TemplateMessage templateMessage) {
            var message = new Message(to, MessageType.TEMPLATE);
            message.templateMessage = templateMessage;
            return message;

        }

        public Message buildInteractiveMessage(InteractiveMessage interactiveMessage) {
            var message = new Message(to, MessageType.INTERACTIVE);
            message.interactiveMessage = interactiveMessage;
            return message;

        }


    }

}

