package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Error data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ErrorData(

        @JsonProperty("details")
        String details
) {
}