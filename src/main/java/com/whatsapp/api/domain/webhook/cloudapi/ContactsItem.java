package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @param profile The {@link Profile} object.
 * @param waId The WhatsApp ID of the customer. You can send messages using this wa_id.
 */
public record ContactsItem(

        @JsonProperty("profile") Profile profile,

        @JsonProperty("wa_id") String waId) {

}