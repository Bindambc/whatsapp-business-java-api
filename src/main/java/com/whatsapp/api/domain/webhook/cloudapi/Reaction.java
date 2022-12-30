package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reaction{

	@JsonProperty("emoji")
	private String emoji;

	@JsonProperty("message_id")
	private String messageId;

	public String getEmoji(){
		return emoji;
	}

	public String getMessageId(){
		return messageId;
	}
}