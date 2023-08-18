package com.whatsapp.api.domain.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GraphCommerceSettings(

        @JsonProperty("data")
        List<CommerceDataItem> data
) {
}