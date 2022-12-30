package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Conversation {

    @JsonProperty("expiration_timestamp")
    private String expirationTimestamp;

    @JsonProperty("origin")
    private Origin origin;

    @JsonProperty("id")
    private String id;

    public String getExpirationTimestamp() {
        return expirationTimestamp;
    }

    public Origin getOrigin() {
        return origin;
    }

    public String getId() {
        return id;
    }
}