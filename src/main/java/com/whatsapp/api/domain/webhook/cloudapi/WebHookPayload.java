package com.whatsapp.api.domain.webhook.cloudapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WebHookPayload{

	@JsonProperty("entry")
	private List<Entry> entry;

	@JsonProperty("object")
	private String object;

	public List<Entry> getEntry(){
		return entry;
	}

	public String getObject(){
		return object;
	}
}