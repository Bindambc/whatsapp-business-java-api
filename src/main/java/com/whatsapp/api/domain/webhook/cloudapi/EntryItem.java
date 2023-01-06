package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record EntryItem(

        @JsonProperty("changes") List<ChangesItem> changes,

        @JsonProperty("id") String id

) {
}