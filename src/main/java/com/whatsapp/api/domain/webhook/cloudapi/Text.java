package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Text{

	@JsonProperty("body")
	private String body;

	public String getBody(){
		return body;
	}
}