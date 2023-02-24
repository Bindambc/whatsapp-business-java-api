
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    @JsonProperty("product_retailer_id")
    public String productRetailerId;

    public String getProductRetailerId() {
        return productRetailerId;
    }

    public Product setProductRetailerId(String productRetailerId) {
        this.productRetailerId = productRetailerId;
        return this;
    }
}
