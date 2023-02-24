package com.whatsapp.api.domain.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Whatsapp api error.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record WhatsappApiError(
        @JsonProperty("error")
        Error error
) {
}
