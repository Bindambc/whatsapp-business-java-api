package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListReply {

    @JsonProperty("description")
    private String description;

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}