package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmailsItem(

        @JsonProperty("type")
        String type,

        @JsonProperty("email")
        String email
) {

}