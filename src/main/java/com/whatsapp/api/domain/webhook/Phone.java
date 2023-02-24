package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Phone.
 */
public record Phone(

        @JsonProperty("phone") String phone,

        @JsonProperty("wa_id") String waId,

        @JsonProperty("type") String type

) {

}