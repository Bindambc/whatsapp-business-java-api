package com.whatsapp.api.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Message template success response.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Response(@JsonProperty("success") boolean success) {
}
