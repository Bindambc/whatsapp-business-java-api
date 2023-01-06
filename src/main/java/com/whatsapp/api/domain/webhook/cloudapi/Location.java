package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(

        @JsonProperty("address") String address,

        @JsonProperty("latitude") String latitude,

        @JsonProperty("name") String name,

        @JsonProperty("longitude") String longitude

) {
}