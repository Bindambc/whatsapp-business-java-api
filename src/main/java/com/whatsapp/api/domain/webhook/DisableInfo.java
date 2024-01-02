package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Disable info.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DisableInfo(@JsonProperty("disable_date") String disableDate) {
}
