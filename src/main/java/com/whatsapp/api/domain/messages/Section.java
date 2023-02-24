
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Required for List Messages and Multi-Product Messages</p>
 *
 * <ul>
 *     <li><b>products: </b><i>Required for Multi-Product Messages</i> - Array of product objects. There is a minimum of 1 product per section and a maximum of 30 products across all sections</li>
 *     <li><b>rows: </b><i>Required for List Messages</i> - Contains a list of rows. You can have a total of 10 rows across your sections. <br> - Each row must have a:
 *     <ul>
 *         <li><b>title: </b><i>Required</i> - Maximum length: 24 characters</li>
 *         <li><b>ID: </b><i>Required</i> - Maximum length: 200 characters</li>
 *         <li><b>description: </b><i>Optional</i> - Maximum length: 72 characters</li>
 *     </ul>
 *     <li><b>title: </b><i>Required if the message has more than one section</i> - Title of the section</li>
 * </ul>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Section {

    @JsonProperty("title")
    public String title;
    @JsonProperty("product_items")
    public List<Product> products;
    @JsonProperty("rows")
    public List<Row> rows;

    public String getTitle() {
        return title;
    }

    public Section setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Product> getProductItems() {
        return products;
    }

    public Section setProductItems(List<Product> products) {
        this.products = products;
        return this;
    }

    public Section addProductItem(Product product) {
        if (this.products == null)
            this.products = new ArrayList<>();

        this.products.add(product);
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
