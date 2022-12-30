package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessagesItem{

	@JsonProperty("reaction")
	private Reaction reaction;
	@JsonProperty("image")
	private Image image;

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

	public Reaction getReaction() {
		return reaction;
	}
	public Image getImage(){
		return image;
	}

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