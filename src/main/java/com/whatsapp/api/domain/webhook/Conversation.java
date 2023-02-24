package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Conversation.
 *
 * @param expirationTimestamp The timestamp when the current ongoing conversation expires. This field is not present in all Webhook types.
 * @param origin              Describes where the conversation originated from. See {@link Origin} object for more information.
 * @param id                  The ID of the conversation the given status notification belongs to.
 */
public record Conversation(

        @JsonProperty("expiration_timestamp") String expirationTimestamp,

        @JsonProperty("origin") Origin origin,

        @JsonProperty("id") String id) {

}