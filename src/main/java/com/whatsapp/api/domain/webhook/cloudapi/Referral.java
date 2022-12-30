package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Referral{

	@JsonProperty("video_url")
	private String videoUrl;

	@JsonProperty("media_type")
	private String mediaType;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("source_type")
	private String sourceType;

	@JsonProperty("source_id")
	private String sourceId;

	@JsonProperty("body")
	private String body;

	@JsonProperty("thumbnail_url")
	private String thumbnailUrl;

	@JsonProperty("headline")
	private String headline;

	@JsonProperty("source_url")
	private String sourceUrl;

	public String getVideoUrl(){
		return videoUrl;
	}

	public String getMediaType(){
		return mediaType;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public String getSourceType(){
		return sourceType;
	}

	public String getSourceId(){
		return sourceId;
	}

	public String getBody(){
		return body;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}

	public String getHeadline(){
		return headline;
	}

	public String getSourceUrl(){
		return sourceUrl;
	}
}