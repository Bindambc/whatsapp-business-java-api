package com.whatsapp.api.domain.media;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Media(

        @JsonProperty("sha256") String sha256,

        @JsonProperty("mime_type") String mimeType,

        @JsonProperty("messaging_product") String messagingProduct,

        @JsonProperty("id") String id,

        @JsonProperty("url") String url,

        @JsonProperty("file_size") String fileSize) {
}