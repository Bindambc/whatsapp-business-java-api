package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UrlsItem(

        @JsonProperty("type") String type,

        @JsonProperty("url") String url) {
}