package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Restriction info.
 */
public record RestrictionInfo(

        @JsonProperty("restriction_type") RestrictionType restrictionType,

        @JsonProperty("expiration") String expiration


) {
}
