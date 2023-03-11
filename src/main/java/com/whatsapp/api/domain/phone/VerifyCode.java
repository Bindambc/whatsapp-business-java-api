package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Verify code.
 */
public record VerifyCode(

        @JsonProperty("code") String code) {
}