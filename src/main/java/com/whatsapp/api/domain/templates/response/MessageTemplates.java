package com.whatsapp.api.domain.templates.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Message templates.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MessageTemplates(

        @JsonProperty("data") List<DataItem> data,

        @JsonProperty("paging") Paging paging) {
}