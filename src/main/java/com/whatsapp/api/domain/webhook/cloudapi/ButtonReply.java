package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ButtonReply{

	@JsonProperty("id")
	private String id;

	@JsonProperty("title")
	private String title;

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}
}