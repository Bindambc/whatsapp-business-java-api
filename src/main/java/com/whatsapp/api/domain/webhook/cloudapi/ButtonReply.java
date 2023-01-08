package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @param id The unique identifier of the button.
 * @param title The title of the button.
 */
public record ButtonReply(

        @JsonProperty("id")
        String id,

        @JsonProperty("title")
        String title
) {
}