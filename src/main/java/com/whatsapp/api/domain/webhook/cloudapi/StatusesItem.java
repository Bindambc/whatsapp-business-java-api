package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StatusesItem(

        @JsonProperty("id") String id,

        @JsonProperty("conversation") Conversation conversation,

        @JsonProperty("pricing") Pricing pricing,

        @JsonProperty("recipient_id") String recipientId,

        @JsonProperty("status") String status,

        @JsonProperty("timestamp") String timestamp) {

}