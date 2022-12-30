package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Interactive{

	@JsonProperty("list_reply")
	private ListReply listReply;

	@JsonProperty("type")
	private String type;

	public ListReply getListReply(){
		return listReply;
	}

	public String getType(){
		return type;
	}
}