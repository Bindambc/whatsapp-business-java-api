package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Context(

        @JsonProperty("from") String from,

        @JsonProperty("referred_product") ReferredProduct referredProduct,

        @JsonProperty("id") String id

) {

}