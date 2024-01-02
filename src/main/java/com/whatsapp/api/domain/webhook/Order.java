package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Order.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Order(

        @JsonProperty("catalog_id") String catalogId,

        @JsonProperty("product_items") List<Product> productItems,

        @JsonProperty("text") String text) {
}