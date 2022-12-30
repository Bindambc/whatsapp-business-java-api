package com.whatsapp.api.domain.webhook.cloudapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Entry {

	@JsonProperty("changes")
	private List<Change> changes;

	@JsonProperty("id")
	private String id;

	public List<Change> getChanges(){
		return changes;
	}

	public String getId(){
		return id;
	}
}