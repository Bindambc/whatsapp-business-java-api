
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Section {

    @JsonProperty("title")
    public String title;
    @JsonProperty("product_items")
    public List<ProductItem> productItems;
    @JsonProperty("rows")
    public List<Row> rows;

    public String getTitle() {
        return title;
    }

    public Section setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public Section setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
        return this;
    }

    public Section addProductItem(ProductItem productItem) {
        if (this.productItems == null)
            this.productItems = new ArrayList<>();

        this.productItems.add(productItem);
        return this;
    }

    public List<Row> getRows() {
        return rows;
    }

    public Section setRows(List<Row> rows) {
        this.rows = rows;
        return this;
    }

    public Section addRow(Row row) {
        if (this.rows == null)
            this.rows = new ArrayList<>();

        this.rows.add(row);
        return this;
    }
}
