package com.whatsapp.api.domain.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Error data.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorData(@JsonProperty("messaging_product") String messagingProduct,
                        @JsonProperty("details") String details,
//TODO: convert to List<String>
                        @JsonProperty("blame_field_specs") Object blameFieldSpecs) {
}
