package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Button(

        @JsonProperty("payload") String payload,

        @JsonProperty("text") String text

) {
}