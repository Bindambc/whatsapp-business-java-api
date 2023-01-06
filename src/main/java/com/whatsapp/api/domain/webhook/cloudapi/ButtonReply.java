package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ButtonReply(

        @JsonProperty("id")
        String id,

        @JsonProperty("title")
        String title
) {
}