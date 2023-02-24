package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Product.
 */
public record Product(

        @JsonProperty("quantity") String quantity,

        @JsonProperty("product_retailer_id") String productRetailerId,

        @JsonProperty("item_price") String itemPrice,

        @JsonProperty("currency") String currency

) {
}