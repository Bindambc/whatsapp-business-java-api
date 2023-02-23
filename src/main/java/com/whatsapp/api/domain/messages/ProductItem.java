
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductItem {

    @JsonProperty("product_retailer_id")
    public String productRetailerId;

    public String getProductRetailerId() {
        return productRetailerId;
    }

    public ProductItem setProductRetailerId(String productRetailerId) {
        this.productRetailerId = productRetailerId;
        return this;
    }
}
