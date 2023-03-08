package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PhoneNumber(

        @JsonProperty("display_phone_number")
        String displayPhoneNumber,

        @JsonProperty("quality_rating")
        String qualityRating,

        @JsonProperty("verified_name")
        String verifiedName,

        @JsonProperty("id")
        String id,

        @JsonProperty("code_verification_status")
        String codeVerificationStatus
) {
}