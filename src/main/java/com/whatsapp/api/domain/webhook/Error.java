package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Error.
 */
public record Error(

        @JsonProperty("code") int code,

        @JsonProperty("details") String details,

        @JsonProperty("title") String title) {
}