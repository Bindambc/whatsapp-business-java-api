package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Two-Step Code
 *
 * @param pin Required. A 6-digit PIN you wish to use for two-step verification.
 */
public record TwoStepCode(
        @JsonProperty("pin") String pin
) {
}
