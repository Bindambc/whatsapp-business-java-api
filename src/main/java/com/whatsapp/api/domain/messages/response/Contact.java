package com.whatsapp.api.domain.messages.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Contact.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Contact(

        @JsonProperty("input") String input,

        @JsonProperty("wa_id") String waId) {
}
