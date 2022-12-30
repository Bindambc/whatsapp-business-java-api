package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailsItem{

	@JsonProperty("type")
	private String type;

	@JsonProperty("email")
	private String email;

	public String getType(){
		return type;
	}

	public String getEmail(){
		return email;
	}
}