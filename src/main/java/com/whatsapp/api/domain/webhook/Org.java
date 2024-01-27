package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Org.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Org(

        @JsonProperty("company") String company,

        @JsonProperty("department") String department,

        @JsonProperty("title") String title) {

}