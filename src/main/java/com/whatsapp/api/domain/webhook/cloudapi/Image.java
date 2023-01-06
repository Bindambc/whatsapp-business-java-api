package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Image(

        @JsonProperty("sha256") String sha256,

        @JsonProperty("mime_type") String mimeType,

        @JsonProperty("caption") String caption,

        @JsonProperty("id") String id) {

}