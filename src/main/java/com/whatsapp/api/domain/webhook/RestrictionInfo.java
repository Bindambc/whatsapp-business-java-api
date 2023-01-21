package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RestrictionInfo(

        @JsonProperty("restriction_type") RestrictionType restrictionType,

        @JsonProperty("expiration") String expiration


) {
}
