package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Document(

        @JsonProperty("filename") String filename,

        @JsonProperty("mime_type") String mimeType,

        @JsonProperty("sha256") String sha256,

        @JsonProperty("id") String id


) {
}
