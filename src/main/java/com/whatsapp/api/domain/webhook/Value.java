package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.EventType;

import java.util.List;

/**
 * The type Value.
 *
 * @param metadata                The metadata about your phone number.
 * @param messagingProduct        The messaging service used for Webhooks. For WhatsApp messages, this value needs to be set to “whatsapp”.
 * @param messages                An array of message objects. Added to Webhooks for incoming message notifications.
 * @param contacts                An array of contacts
 * @param statuses                An array of message status objects. Added to Webhooks for message status update.
 * @param decision                Used if a decision about accounts or phone numbers has been made. (APPROVED or REJECTED)
 * @param displayPhoneNumber      Includes the display phone number of the business  account that triggered the notification.
 * @param event                   Used when an event happened in a specific WABA. See {@link EventType}
 * @param messageTemplateId       The message template ID
 * @param messageTemplateLanguage The message template language
 * @param messageTemplateName     The message template name
 * @param phoneNumber             the phone number
 * @param reason                  reason
 * @param rejectionReason         If a request was rejected, this field displays the reason for that rejection.
 * @param requestedVerifiedName   This field displays the name that was sent to be verified.
 */
public record Value(

        @JsonProperty("metadata") Metadata metadata,

        @JsonProperty("messaging_product") String messagingProduct,

        @JsonProperty("messages") List<Message> messages,

        @JsonProperty("contacts") List<Contact> contacts,

        @JsonProperty("statuses") List<Status> statuses,

        @JsonProperty("event") EventType event,

        @JsonProperty("phone_number") String phoneNumber,

        @JsonProperty("message_template_id") String messageTemplateId,

        @JsonProperty("message_template_name") String messageTemplateName,

        @JsonProperty("message_template_language") String messageTemplateLanguage,

        @JsonProperty("reason") String reason,

        @JsonProperty("display_phone_number") String displayPhoneNumber, @JsonProperty("decision") String decision,

        @JsonProperty("requested_verified_name") String requestedVerifiedName,

        @JsonProperty("rejection_reason") Object rejectionReason,

        @JsonProperty("disable_info") DisableInfo disableInfo,

        @JsonProperty("current_limit") String currentLimit,

        @JsonProperty("ban_info") BanInfo banInfo,

        @JsonProperty("restriction_info") List<RestrictionInfo> restrictionInfo


) {


}