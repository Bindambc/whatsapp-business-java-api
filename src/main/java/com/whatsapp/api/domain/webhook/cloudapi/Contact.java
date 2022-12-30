package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {

	@JsonProperty("profile")
	private Profile profile;

	@JsonProperty("wa_id")
	private String waId;

	public Profile getProfile(){
		return profile;
	}

	public String getWaId(){
		return waId;
	}
}