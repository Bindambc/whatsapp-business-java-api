package com.whatsapp.api.domain.templates.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Cursors(

        @JsonProperty("before") String before,

        @JsonProperty("after") String after) {
}