package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Product.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    /**
     * The Product retailer id.
     */
    @JsonProperty("product_retailer_id")
    public String productRetailerId;

    /**
     * Gets product retailer id.
     *
     * @return the product retailer id
     */
    public String getProductRetailerId() {
        return productRetailerId;
    }

    /**
     * Sets product retailer id.
     *
     * @param productRetailerId the product retailer id
     * @return the product retailer id
     */
    public Product setProductRetailerId(String productRetailerId) {
        this.productRetailerId = productRetailerId;
        return this;
    }
}
