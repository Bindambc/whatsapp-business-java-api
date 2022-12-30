package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangesItem{

	@JsonProperty("field")
	private String field;

	@JsonProperty("value")
	private Value value;

	public String getField(){
		return field;
	}

	public Value getValue(){
		return value;
	}
}