package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Email(

        @JsonProperty("type")
        String type,

        @JsonProperty("email")
        String email
) {

}