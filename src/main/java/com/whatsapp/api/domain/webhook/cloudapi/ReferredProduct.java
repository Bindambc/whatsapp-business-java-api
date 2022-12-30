package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferredProduct{

	@JsonProperty("catalog_id")
	private String catalogId;

	@JsonProperty("product_retailer_id")
	private String productRetailerId;

	public String getCatalogId(){
		return catalogId;
	}

	public String getProductRetailerId(){
		return productRetailerId;
	}
}