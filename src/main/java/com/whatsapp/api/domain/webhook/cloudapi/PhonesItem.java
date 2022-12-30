package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhonesItem {

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("wa_id")
    private String waId;

    @JsonProperty("type")
    private String type;

    public String getPhone() {
        return phone;
    }

    public String getWaId() {
        return waId;
    }

    public String getType() {
        return type;
    }
}