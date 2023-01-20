package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Error(

        @JsonProperty("code") int code,

        @JsonProperty("details") String details,

        @JsonProperty("title") String title) {
}