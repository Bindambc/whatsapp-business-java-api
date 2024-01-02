package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.RestrictionType;

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE;

/**
 * The type Restriction info.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(with = READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)
public record RestrictionInfo(

        @JsonProperty("restriction_type") RestrictionType restrictionType,

        @JsonProperty("expiration") String expiration


) {
}
