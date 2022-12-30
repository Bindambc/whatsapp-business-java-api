package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductItemsItem{

	@JsonProperty("quantity")
	private String quantity;

	@JsonProperty("product_retailer_id")
	private String productRetailerId;

	@JsonProperty("item_price")
	private String itemPrice;

	@JsonProperty("currency")
	private String currency;

	public String getQuantity(){
		return quantity;
	}

	public String getProductRetailerId(){
		return productRetailerId;
	}

	public String getItemPrice(){
		return itemPrice;
	}

	public String getCurrency(){
		return currency;
	}
}