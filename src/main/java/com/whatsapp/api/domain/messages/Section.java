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

    /**
     * The Title.
     */
    @JsonProperty("title")
    public String title;
    /**
     * The Products.
     */
    @JsonProperty("product_items")
    public List<Product> products;
    /**
     * The Rows.
     */
    @JsonProperty("rows")
    public List<Row> rows;

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     * @return the title
     */
    public Section setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Gets product items.
     *
     * @return the product items
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets product items.
     *
     * @param products the products
     * @return the product items
     */
    public Section setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    /**
     * Add product item section.
     *
     * @param product the product
     * @return the section
     */
    public Section addProductItem(Product product) {
        if (this.products == null)
            this.products = new ArrayList<>();

        this.products.add(product);
        return this;
    }

    /**
     * Gets rows.
     *
     * @return the rows
     */
    public List<Row> getRows() {
        return rows;
    }

    /**
     * Sets rows.
     *
     * @param rows the rows
     * @return the rows
     */
    public Section setRows(List<Row> rows) {
        this.rows = rows;
        return this;
    }

    /**
     * Add row section.
     *
     * @param row the row
     * @return the section
     */
    public Section addRow(Row row) {
        if (this.rows == null)
            this.rows = new ArrayList<>();

        this.rows.add(row);
        return this;
    }
}
