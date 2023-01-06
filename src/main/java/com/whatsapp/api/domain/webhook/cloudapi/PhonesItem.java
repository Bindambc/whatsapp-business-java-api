package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PhonesItem(

        @JsonProperty("phone") String phone,

        @JsonProperty("wa_id") String waId,

        @JsonProperty("type") String type

) {

}