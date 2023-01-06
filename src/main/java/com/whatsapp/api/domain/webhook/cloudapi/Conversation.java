package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Conversation(

        @JsonProperty("expiration_timestamp") String expirationTimestamp,

        @JsonProperty("origin") Origin origin,

        @JsonProperty("id") String id) {

}