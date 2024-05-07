package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Email.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Email(

        @JsonProperty("type")
        String type,

        @JsonProperty("email")
        String email
) {

}