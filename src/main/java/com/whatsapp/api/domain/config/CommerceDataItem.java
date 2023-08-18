package com.whatsapp.api.domain.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Commerce data item.
 *
 * <ul>
 * <li> <b>is_catalog_visible</b> - <i>Optional</i>. Set to true to enable cart and display cart-related buttons in the business phone number's messages, catalogs, and product details.
 * Set to false to disable cart. When disabled, customers can see products and their details in messages, but all cart related buttons will not appear in any message view.
 * <br>
 *
 * <li> <b>is_cart_enabled</b> – <i>Optional</i>. Set to true to enable catalog. When enabled, catalog storefront icon and catalog-related buttons appear in the business phone number's messages and business profile.
 * Set to false to disable catalog. If disabled, the storefront icon and catalog-related buttons will not appear in any views and the catalog preview with thumbnails will not appear in the business profile view.
 * In addition, wa.me links to the business's catalog, as well as the View catalog button that appears when sending catalog links in a message will display an Invalid catalog link warning when tapped.
 * </ul>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommerceDataItem {
    @JsonProperty("id")
    private String id;

    @JsonProperty("is_catalog_visible")
    private Boolean isCatalogVisible;

    @JsonProperty("is_cart_enabled")
    private Boolean isCartEnabled;

    public CommerceDataItem() {
    }

    public String getId() {
        return id;
    }

    public Boolean isCatalogVisible() {
        return isCatalogVisible;
    }

    public CommerceDataItem setCatalogVisible(Boolean catalogVisible) {
        isCatalogVisible = catalogVisible;
        return this;
    }

    public Boolean isCartEnabled() {
        return isCartEnabled;
    }

    public CommerceDataItem setCartEnabled(Boolean cartEnabled) {
        isCartEnabled = cartEnabled;
        return this;
    }
}