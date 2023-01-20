package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @param metadata         The metadata about your phone number.
 * @param messagingProduct The messaging service used for Webhooks. For WhatsApp messages, this value needs to be set to “whatsapp”.
 * @param messages         An array of message objects. Added to Webhooks for incoming message notifications.
 * @param contacts         An array of contacts
 * @param statuses         An array of message status objects. Added to Webhooks for message status update.
 */
public record Value(

        @JsonProperty("metadata") Metadata metadata,

        @JsonProperty("messaging_product") String messagingProduct,

        @JsonProperty("messages") List<Message> messages,

        @JsonProperty("contacts") List<Contact> contacts,

        @JsonProperty("statuses") List<Status> statuses,

        @JsonProperty("event") String event,

        @JsonProperty("phone_number") String phoneNumber,

        @JsonProperty("message_template_id") String messageTemplateId,

        @JsonProperty("message_template_name") String messageTemplateName,


        @JsonProperty("message_template_language") String messageTemplateLanguage,


        @JsonProperty("reason") String reason


) {


}