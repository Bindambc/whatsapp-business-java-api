package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductItemsItem(

        @JsonProperty("quantity") String quantity,

        @JsonProperty("product_retailer_id") String productRetailerId,

        @JsonProperty("item_price") String itemPrice,

        @JsonProperty("currency") String currency

) {
}