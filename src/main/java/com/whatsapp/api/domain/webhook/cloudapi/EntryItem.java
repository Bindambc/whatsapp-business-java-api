package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EntryItem {

    @JsonProperty("changes")
    private List<ChangesItem> changes;

    @JsonProperty("id")
    private String id;

    public List<ChangesItem> getChanges() {
        return changes;
    }

    public String getId() {
        return id;
    }
}