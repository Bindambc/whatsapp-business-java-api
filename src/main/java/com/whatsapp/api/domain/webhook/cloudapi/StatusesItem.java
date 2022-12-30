package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusesItem {

    @JsonProperty("id")
    private String id;

    @JsonProperty("conversation")
    private Conversation conversation;

    @JsonProperty("pricing")
    private Pricing pricing;

    @JsonProperty("recipient_id")
    private String recipientId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("timestamp")
    private String timestamp;

    public String getId() {
        return id;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public String getStatus() {
        return status;
    }

    public String getTimestamp() {
        return timestamp;
    }
}