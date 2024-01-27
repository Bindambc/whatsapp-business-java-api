package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Optional.
 *
 * @param name Specifies the sender's profile name.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Profile(

        @JsonProperty("name") String name

) {
}