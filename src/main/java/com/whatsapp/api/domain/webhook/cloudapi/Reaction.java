package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Reaction(

        @JsonProperty("emoji") String emoji,

        @JsonProperty("message_id") String messageId

) {
}