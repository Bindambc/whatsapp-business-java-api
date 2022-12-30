package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Origin{

	@JsonProperty("type")
	private String type;

	public String getType(){
		return type;
	}
}