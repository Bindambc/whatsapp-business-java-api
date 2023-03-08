package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.response.Paging;

import java.util.List;

public record PhoneNumbers(

        @JsonProperty("data") List<PhoneNumber> data,

        @JsonProperty("paging") Paging paging) {
}