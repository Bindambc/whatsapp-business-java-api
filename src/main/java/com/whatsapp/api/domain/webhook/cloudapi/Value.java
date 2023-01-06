package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Value(

        @JsonProperty("metadata") Metadata metadata,

        @JsonProperty("messaging_product") String messagingProduct,

        @JsonProperty("messages") List<MessagesItem> messages,

        @JsonProperty("contacts") List<ContactsItem> contacts,

        @JsonProperty("statuses") List<StatusesItem> statuses) {


}