package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile {

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }
}