package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Sticker.
 *
 * @param sha256   The checksum of the media.
 * @param mimeType The mime type of the media.                 The caption that describes the media.
 * @param id       The ID of the medi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Sticker(

        @JsonProperty("sha256") String sha256,

        @JsonProperty("mime_type") String mimeType,

        @JsonProperty("id") String id,

        @JsonProperty("animated") boolean animated) {

}