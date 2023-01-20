package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @param profile The {@link Profile} object.
 * @param waId    The WhatsApp ID of the customer. You can send messages using this wa_id.
 */
public record Contact(

        @JsonProperty("profile") Profile profile,

        @JsonProperty("name") Name namem,

        @JsonProperty("phones") List<Phone> phones,

        @JsonProperty("wa_id") String waId) {

}