package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * When messages type is set to document, this object is included in the messages object.
 *
 * @param filename Name for the file on the sender's device
 * @param mimeType Mime type of the document file
 * @param sha256   Hash
 * @param id       ID for the document
 * @param caption  Caption for the document, if provided
 */
public record Document(

        @JsonProperty("filename") String filename,

        @JsonProperty("mime_type") String mimeType,

        @JsonProperty("sha256") String sha256,

        @JsonProperty("id") String id,

        @JsonProperty("caption") String caption


) {
}
