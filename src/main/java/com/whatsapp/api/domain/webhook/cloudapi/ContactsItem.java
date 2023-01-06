package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactsItem(

        @JsonProperty("profile") Profile profile,

        @JsonProperty("wa_id") String waId) {

}