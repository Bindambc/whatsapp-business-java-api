package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Order {

    @JsonProperty("catalog_id")
    private String catalogId;

    @JsonProperty("product_items")
    private List<ProductItemsItem> productItems;

    @JsonProperty("text")
    private String text;

    public String getCatalogId() {
        return catalogId;
    }

    public List<ProductItemsItem> getProductItems() {
        return productItems;
    }

    public String getText() {
        return text;
    }
}