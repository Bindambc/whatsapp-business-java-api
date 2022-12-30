package com.whatsapp.api.domain.webhook.cloudapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Value{

	@JsonProperty("metadata")
	private Metadata metadata;

	@JsonProperty("messaging_product")
	private String messagingProduct;

	@JsonProperty("messages")
	private List<MessagesItem> messages;

	@JsonProperty("contacts")
	private List<ContactsItem> contacts;

	public Metadata getMetadata(){
		return metadata;
	}

	public String getMessagingProduct(){
		return messagingProduct;
	}

	public List<MessagesItem> getMessages(){
		return messages;
	}

	public List<ContactsItem> getContacts(){
		return contacts;
	}
}