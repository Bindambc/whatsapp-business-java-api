package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WebHookPayload {

    @JsonProperty("entry")
    private List<EntryItem> entry;

    @JsonProperty("object")
    private String object;

    public List<EntryItem> getEntry() {
        return entry;
    }

    public String getObject() {
        return object;
    }
}