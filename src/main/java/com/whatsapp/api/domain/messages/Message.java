package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.MessageType;

import java.util.List;

/**
 * To send a message, you must first assemble a message object with the content you want to send.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages">API documentation - messages</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    @JsonProperty("messaging_product")
    private final String messagingProduct = "whatsapp";
    @JsonProperty("recipient_type")
    private final String recipientType = "individual";
    @JsonProperty("context")
    private Context context;
    /**
     * The Interactive message.
     */
    @JsonProperty("interactive")
    private InteractiveMessage interactiveMessage;
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

    @JsonProperty("audio")
    private AudioMessage audioMessage;

    @JsonProperty("document")
    private DocumentMessage documentMessage;

    @JsonProperty("image")
    private ImageMessage imageMessage;

    @JsonProperty("sticker")
    private StickerMessage stickerMessage;

    @JsonProperty("video")
    private VideoMessage videoMessage;

    @JsonProperty("reaction")
    private ReactionMessage reactionMessage;

    @JsonProperty("location")
    private LocationMessage locationMessage;


    private Message() {
    }

    private Message(String to, MessageType type, Context context) {
        this.to = to;
        this.type = type;
        this.context = context;
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
     * Gets context.
     *
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * Gets interactive message.
     * @return the interactive message
     */
    public InteractiveMessage getInteractiveMessage() {
        return interactiveMessage;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Gets text message.
     *
     * @return the text message
     */
    public TextMessage getTextMessage() {
        return textMessage;
    }

    /**
     * Gets contact message.
     *
     * @return the contact message
     */
    public List<Contact> getContactMessage() {
        return contactMessage;
    }

    /**
     * Gets template message.
     *
     * @return the template message
     */
    public TemplateMessage getTemplateMessage() {
        return templateMessage;
    }

    /**
     * Gets audio message.
     *
     * @return the audio message
     */
    public AudioMessage getAudioMessage() {
        return audioMessage;
    }

    /**
     * Gets document message.
     *
     * @return the document message
     */
    public DocumentMessage getDocumentMessage() {
        return documentMessage;
    }

    /**
     * Gets image message.
     *
     * @return the image message
     */
    public ImageMessage getImageMessage() {
        return imageMessage;
    }

    /**
     * Gets sticker message.
     *
     * @return the sticker message
     */
    public StickerMessage getStickerMessage() {
        return stickerMessage;
    }

    /**
     * Gets video message.
     *
     * @return the video message
     */
    public VideoMessage getVideoMessage() {
        return videoMessage;
    }

    /**
     * Gets reaction message.
     *
     * @return the reaction message
     */
    public ReactionMessage getReactionMessage() {
        return reactionMessage;
    }

    /**
     * Gets location message.
     *
     * @return the location message
     */
    public LocationMessage getLocationMessage() {
        return locationMessage;
    }

    /**
     * The type Message builder.
     */
    public static class MessageBuilder {

        private String to;
        private Context context;


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
         * Sets context.
         *
         * @param context. the messsage's context.
         * @return the context
         */
        public MessageBuilder setContext(Context context) {
            this.context = context;
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
            var message = new Message(to, MessageType.TEXT, context);
            message.textMessage = textMessage;
            return message;


        }

        /**
         * <b>Required</b>.
         * Build an objetc with {@link Contact}
         *
         * @param contactMessage the contact message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#contacts-object">API documentation</a>
         */
        public Message buildContactMessage(ContactMessage contactMessage) {
            var message = new Message(to, MessageType.CONTACTS, context);
            message.contactMessage = contactMessage.getContacts();
            return message;

        }

        /**
         * Build template message
         *
         * @param templateMessage the template message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#template-object">API documentation</a>
         */
        public Message buildTemplateMessage(TemplateMessage templateMessage) {
            var message = new Message(to, MessageType.TEMPLATE, context);
            message.templateMessage = templateMessage;
            return message;

        }

        /**
         * Build an object to send an {@link InteractiveMessage}
         *
         * @param interactiveMessage the interactive message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#interactive-object">API documentation</a>
         */
        public Message buildInteractiveMessage(InteractiveMessage interactiveMessage) {
            var message = new Message(to, MessageType.INTERACTIVE, context);
            message.interactiveMessage = interactiveMessage;
            return message;

        }


        /**
         * Build audio message
         *
         * @param audioMessage the audio message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Message buildAudioMessage(AudioMessage audioMessage) {
            var message = new Message(to, MessageType.AUDIO, context);
            message.audioMessage = audioMessage;
            return message;

        }

        /**
         * Build document message
         *
         * @param documentMessage the document message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Message buildDocumentMessage(DocumentMessage documentMessage) {
            var message = new Message(to, MessageType.DOCUMENT, context);
            message.documentMessage = documentMessage;
            return message;

        }

        /**
         * Build image message
         *
         * @param imageMessage the image message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Message buildImageMessage(ImageMessage imageMessage) {
            var message = new Message(to, MessageType.IMAGE, context);
            message.imageMessage = imageMessage;
            return message;

        }

        /**
         * Build sticker message
         *
         * @param stickerMessage the sticker message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Message buildStickerMessage(StickerMessage stickerMessage) {
            var message = new Message(to, MessageType.STICKER, context);
            message.stickerMessage = stickerMessage;
            return message;

        }

        /**
         * Build video message
         *
         * @param videoMessage the video message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">API documentation</a>
         */
        public Message buildVideoMessage(VideoMessage videoMessage) {
            var message = new Message(to, MessageType.VIDEO, context);
            message.videoMessage = videoMessage;
            return message;

        }

        /**
         * Build reaction message
         *
         * @param reactionMessage the reaction message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#location-object">API documentation</a>
         */
        public Message buildReactionMessage(ReactionMessage reactionMessage) {
            var message = new Message(to, MessageType.REACTION, context);
            message.reactionMessage = reactionMessage;
            return message;

        }

        /**
         * Build location message
         *
         * @param locationMessage the location message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#location-messages">API documentation</a>
         */
        public Message buildLocationMessage(LocationMessage locationMessage) {
            var message = new Message(to, MessageType.LOCATION, context);
            message.locationMessage = locationMessage;
            return message;

        }

    }

}

