package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MessagesItem(

        @JsonProperty("reaction") Reaction reaction,

        @JsonProperty("image") Image image,

        @JsonProperty("sticker") Sticker sticker,

        @JsonProperty("location") Location location,

        @JsonProperty("contacts") List<ContactsItem> contacts,


        @JsonProperty("button") Button button,

        @JsonProperty("context") Context context,

        @JsonProperty("from") String from,

        @JsonProperty("id") String id,

        @JsonProperty("text") Text text,

        @JsonProperty("errors") List<ErrorsItem> errors,

        @JsonProperty("type") String type,

        @JsonProperty("interactive") Interactive interactive,

        @JsonProperty("timestamp") String timestamp,

        @JsonProperty("referral") Referral referral,

        @JsonProperty("order") Order order,

        @JsonProperty("system") System system,

        @JsonProperty("video") Video video) {
}