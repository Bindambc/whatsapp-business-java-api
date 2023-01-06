package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChangesItem(

        @JsonProperty("field") String field,

        @JsonProperty("value") Value value) {
}