package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image{

	@JsonProperty("sha256")
	private String sha256;

	@JsonProperty("mime_type")
	private String mimeType;

	@JsonProperty("caption")
	private String caption;

	@JsonProperty("id")
	private String id;

	public String getSha256(){
		return sha256;
	}

	public String getMimeType(){
		return mimeType;
	}

	public String getCaption(){
		return caption;
	}

	public String getId(){
		return id;
	}
}