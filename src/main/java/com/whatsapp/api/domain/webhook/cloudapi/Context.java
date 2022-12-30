package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Context{

	@JsonProperty("from")
	private String from;

	@JsonProperty("id")
	private String id;

	public String getFrom(){
		return from;
	}

	public String getId(){
		return id;
	}
}