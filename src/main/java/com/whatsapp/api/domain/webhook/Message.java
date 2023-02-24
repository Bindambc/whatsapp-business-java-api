package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.MessageType;

import java.util.List;

/**
 * The type Message.
 *
 * @param reaction    A reaction object. See {@link Reaction}
 * @param image       A media object with the image information. Added to Webhook if type is image. See {@link Image}
 * @param sticker     A media object with the sticker information. Added to Webhook if type is sticker. See {@link Sticker}
 * @param location    Location
 * @param contacts    Contacts
 * @param button      Added to Webhook if type is button. This field is used when the Webhook notifies you that a user clicked on a quick reply button. See {@link Button}
 * @param context     Added to Webhook if message is forwarded or an inbound reply. See {@link Context}
 * @param from        The customer's phone number.
 * @param id          The unique identifier of incoming message, you can use messages endpoint to mark it as read.
 * @param text        A text object. Added to Webhook if type is text. See {@link Text}
 * @param errors      Added to Webhook if type is unknown. See {@link Error}
 * @param type        Supported values are:                                <ul>                      <li>text: for text messages.</li>                      <li>image: for image (media) messages.</li>                      <li>interactive: for interactive messages.</li>                      <li>document: for document (media) messages.</li>                      <li>audio: for audio and voice (media) messages.</li>                      <li>sticker: for sticker messages.</li>                      <li>order: for when a customer has placed an order.</li>                      <li>video: for video (media) messages.</li>                      <li>button: for responses to interactive message templates.</li>                      <li>contacts: for contact messages.</li>                      <li>location: for location messages.</li>                      <li>unknown: for unknown messages.</li>                      <li>system: for user number change messages.</li>                    </ul>
 * @param interactive When a customer has interacted with your message, an interactive object is included in the {@link Message} object
 * @param timestamp   The timestamp when a customer sends a message.
 * @param referral    Added to Webhook if the message is coming from a user that clicked an ad that is Click To WhatsApp.                    A referral object. This is how the referral object works:<ul>                    <li>A user clicks on an ad with the Click to WhatsApp call-to-action.</li>                    <li>User is redirected to WhatsApp and sends a message to the advertising business.</li>                    <li>User sends a message to the business. Be aware that users may elect to remove their referral data.</li>                    <li>The advertising business gets an inbound message notification including the referral object, which provides additional context on the ad that triggered the message. Knowing all this information, the business can appropriately reply to the user message.</li></ul>
 * @param order       Included in the Messages object when a customer has placed an order. See {@link Order}
 * @param system      Added to Webhook if type is system. See {@link System}
 * @param video       A media object with the video information. Added to Webhook if type is video. See {@link Video}
 * @param audio       A media object with the audio information. Added to Webhook if type is audio (including voice messages). See {@link Audio}
 * @param document    A media object with the document information. Added to Webhook if type is document. See {@link Document}
 */
public record Message(

        @JsonProperty("reaction") Reaction reaction,

        @JsonProperty("image") Image image,

        @JsonProperty("sticker") Sticker sticker,

        @JsonProperty("location") Location location,

        @JsonProperty("contacts") List<Contact> contacts,


        @JsonProperty("button") Button button,

        @JsonProperty("context") Context context,

        @JsonProperty("from") String from,

        @JsonProperty("id") String id,

        @JsonProperty("text") Text text,

        @JsonProperty("errors") List<Error> errors,

        @JsonProperty("type") MessageType type,

        @JsonProperty("interactive") Interactive interactive,

        @JsonProperty("timestamp") String timestamp,

        @JsonProperty("referral") Referral referral,

        @JsonProperty("order") Order order,

        @JsonProperty("system") System system,

        @JsonProperty("video") Video video,

        @JsonProperty("audio") Audio audio,

        @JsonProperty("document") Document document) {
}