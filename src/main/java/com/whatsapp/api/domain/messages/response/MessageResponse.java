package com.whatsapp.api.domain.messages.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Message response.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MessageResponse(

        @JsonProperty("messaging_product") String messagingProduct,

        @JsonProperty("contacts") List<Contact> contacts,

        @JsonProperty("messages") List<Message> messages) {
}
