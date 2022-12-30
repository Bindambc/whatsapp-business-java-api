package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Button{

	@JsonProperty("payload")
	private String payload;

	@JsonProperty("text")
	private String text;

	public String getPayload(){
		return payload;
	}

	public String getText(){
		return text;
	}
}