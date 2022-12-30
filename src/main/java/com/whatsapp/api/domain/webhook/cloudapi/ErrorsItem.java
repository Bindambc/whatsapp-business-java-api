package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorsItem {

    @JsonProperty("code")
    private int code;

    @JsonProperty("details")
    private String details;

    @JsonProperty("title")
    private String title;

    public int getCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }

    public String getTitle() {
        return title;
    }
}