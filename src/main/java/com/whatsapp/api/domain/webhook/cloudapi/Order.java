package com.whatsapp.api.domain.webhook.cloudapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order{

	@JsonProperty("catalog_id")
	private String catalogId;

	@JsonProperty("product_items")
	private List<ProductItemsItem> productItems;

	@JsonProperty("text")
	private String text;

	public String getCatalogId(){
		return catalogId;
	}

	public List<ProductItemsItem> getProductItems(){
		return productItems;
	}

	public String getText(){
		return text;
	}
}