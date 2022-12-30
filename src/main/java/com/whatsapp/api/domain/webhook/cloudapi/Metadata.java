package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {

    @JsonProperty("phone_number_id")
    private String phoneNumberId;

    @JsonProperty("display_phone_number")
    private String displayPhoneNumber;

    public String getPhoneNumberId() {
        return phoneNumberId;
    }

    public String getDisplayPhoneNumber() {
        return displayPhoneNumber;
    }
}