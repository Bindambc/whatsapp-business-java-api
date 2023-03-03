package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.MessageStatus;

import java.util.List;

/**
 * The type Status.
 *
 * @param id           The message ID.
 * @param conversation This object will be provided by default when Conversation-Based Pricing launches in a future update.                     Object containing conversation attributes, including id. See conversation object for more information.                     <p>                     WhatsApp defines a conversation as a 24-hour session of messaging between a person and a business. There is no limit on the number of messages that can be exchanged in the fixed 24-hour window. The 24-hour conversation session begins when:                     <ul><li>A business-initiated message is delivered to a user</li>                     <li>A business’ reply to a user message is delivered</li>                     </ul>                     <p>                     The 24-hour conversation session is different from the 24-hour customer support window. The customer support window is a rolling window that is refreshed when a user-initiated message is delivered to a business. Within the customer support window businesses can send free-form messages. Any business-initiated message sent more than 24 hours after the last customer message must be a template message.
 * @param pricing      This object will be provided by default when Conversation-Based Pricing launches in a future update.
 * @param recipientId  The WhatsApp ID of the recipient.
 * @param status       The status of the message. Valid values are: read, delivered, sent, failed, or deleted.
 * @param timestamp    The timestamp of the status message.
 * @param errors       The errors object in webhooks triggered by v16.0+ request errors now include message and error_data.details properties, and title values have changed for multiple error codes.
 */
public record Status(

        @JsonProperty("id") String id,

        @JsonProperty("conversation") Conversation conversation,

        @JsonProperty("pricing") Pricing pricing,

        @JsonProperty("recipient_id") String recipientId,

        @JsonProperty("status") MessageStatus status,

        @JsonProperty("timestamp") String timestamp,

        @JsonProperty("errors") List<Error> errors) {

}