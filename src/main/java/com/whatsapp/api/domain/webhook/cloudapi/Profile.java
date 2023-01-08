package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Optional.
 *
 * @param name Specifies the sender's profile name.
 */
public record Profile(

        @JsonProperty("name") String name

) {
}