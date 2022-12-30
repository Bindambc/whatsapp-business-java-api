package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

	@JsonProperty("from")
	private String from;

	@JsonProperty("id")
	private String id;

	@JsonProperty("text")
	private Text text;

	@JsonProperty("type")
	private String type;

	@JsonProperty("timestamp")
	private String timestamp;

	public String getFrom(){
		return from;
	}

	public String getId(){
		return id;
	}

	public Text getText(){
		return text;
	}

	public String getType(){
		return type;
	}

	public String getTimestamp(){
		return timestamp;
	}
}