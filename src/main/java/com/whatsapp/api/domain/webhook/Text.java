package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @param body The text of the text message.
 */
public record Text(

        @JsonProperty("body") String body) {
}