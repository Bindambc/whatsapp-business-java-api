package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlsItem{

	@JsonProperty("type")
	private String type;

	@JsonProperty("url")
	private String url;

	public String getType(){
		return type;
	}

	public String getUrl(){
		return url;
	}
}