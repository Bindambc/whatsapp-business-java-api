package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DisplayNameStatus(

        @JsonProperty("name_status")
        String nameStatus,

        @JsonProperty("id")
        String id
) {
}