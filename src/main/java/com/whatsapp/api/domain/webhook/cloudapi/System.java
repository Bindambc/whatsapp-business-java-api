package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class System {

    @JsonProperty("new_wa_id")
    private String newWaId;

    @JsonProperty("body")
    private String body;

    @JsonProperty("type")
    private String type;

    public String getNewWaId() {
        return newWaId;
    }

    public String getBody() {
        return body;
    }

    public String getType() {
        return type;
    }
}