package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Referred product.
 */
public record ReferredProduct(

        @JsonProperty("catalog_id") String catalogId,

        @JsonProperty("product_retailer_id") String productRetailerId) {

}