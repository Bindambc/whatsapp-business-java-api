package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VerifyCode(

        @JsonProperty("code") String code) {
}