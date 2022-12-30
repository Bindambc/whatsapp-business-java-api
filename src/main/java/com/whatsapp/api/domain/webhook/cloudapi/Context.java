package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Context{

	@JsonProperty("from")
	private String from;

	@JsonProperty("referred_product")
	private ReferredProduct referredProduct;

	@JsonProperty("id")
	private String id;

	public String getFrom(){
		return from;
	}

	public ReferredProduct getReferredProduct(){
		return referredProduct;
	}

	public String getId(){
		return id;
	}
}