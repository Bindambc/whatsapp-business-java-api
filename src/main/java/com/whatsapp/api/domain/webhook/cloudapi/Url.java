package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Url(

        @JsonProperty("type") String type,

        @JsonProperty("url") String url) {
}