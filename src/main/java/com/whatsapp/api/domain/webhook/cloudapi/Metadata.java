package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Metadata(

        @JsonProperty("phone_number_id") String phoneNumberId,

        @JsonProperty("display_phone_number") String displayPhoneNumber) {
}