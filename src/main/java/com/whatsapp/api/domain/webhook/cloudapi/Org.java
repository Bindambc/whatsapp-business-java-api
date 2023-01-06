package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Org(

        @JsonProperty("company") String company,

        @JsonProperty("department") String department,

        @JsonProperty("title") String title) {

}