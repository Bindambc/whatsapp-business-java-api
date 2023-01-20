package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Email(

        @JsonProperty("type")
        String type,

        @JsonProperty("email")
        String email
) {

}