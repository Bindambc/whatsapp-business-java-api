package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Origin(

        @JsonProperty("type") String type

) {
}