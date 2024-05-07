package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Address.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Address(

        @JsonProperty("zip") String zip,

        @JsonProperty("country") String country,

        @JsonProperty("country_code") String countryCode,

        @JsonProperty("city") String city,

        @JsonProperty("street") String street,

        @JsonProperty("state") String state,

        @JsonProperty("type") String type) {


}