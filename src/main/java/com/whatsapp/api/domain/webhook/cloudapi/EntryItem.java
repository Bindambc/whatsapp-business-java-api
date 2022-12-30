package com.whatsapp.api.domain.webhook.cloudapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EntryItem{

	@JsonProperty("changes")
	private List<ChangesItem> changes;

	@JsonProperty("id")
	private String id;

	public List<ChangesItem> getChanges(){
		return changes;
	}

	public String getId(){
		return id;
	}
}