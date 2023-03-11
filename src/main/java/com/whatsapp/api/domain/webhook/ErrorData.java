package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Error data.
 */
public record ErrorData(

        @JsonProperty("details")
        String details
) {
}