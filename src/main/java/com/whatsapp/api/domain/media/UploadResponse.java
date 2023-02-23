package com.whatsapp.api.domain.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UploadResponse(@JsonProperty("id") String id) {
}
