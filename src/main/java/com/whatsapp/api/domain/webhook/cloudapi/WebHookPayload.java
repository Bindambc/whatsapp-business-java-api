package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WebHookPayload(

        @JsonProperty("entry") List<EntryItem> entry,

        @JsonProperty("object") String object) {
}