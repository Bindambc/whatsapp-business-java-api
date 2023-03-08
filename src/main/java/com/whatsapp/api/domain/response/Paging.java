package com.whatsapp.api.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Paging.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Paging(@JsonProperty("cursors") Cursors cursors,

                     @JsonProperty("next") String next) {


}