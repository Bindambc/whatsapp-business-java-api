package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Reaction.
 *
 * @param emoji     The emoji used for the reaction.
 * @param messageId Specifies the wamid of the message received that contained the reaction.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Reaction(

        @JsonProperty("emoji") String emoji,

        @JsonProperty("message_id") String messageId

) {
}