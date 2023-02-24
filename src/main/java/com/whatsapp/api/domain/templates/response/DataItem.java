package com.whatsapp.api.domain.templates.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.Component;

import java.util.List;

/**
 * The type Data item.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record DataItem(

        @JsonProperty("components") List<Component> components,

        @JsonProperty("name") String name,

        @JsonProperty("language") String language,

        @JsonProperty("id") String id,

        @JsonProperty("category") String category,

        @JsonProperty("status") String status) {
}