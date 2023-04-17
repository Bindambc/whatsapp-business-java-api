package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * To mark the message as read, you must first create Read message object
 * 
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/mark-message-as-read">API documentation - messages</a>
 */
public class ReadMessage {
	
	@JsonProperty("messaging_product")
    private final String messagingProduct = "whatsapp";
	
    @JsonProperty("status")
    private String status = "read";

    @JsonProperty("message_id")
    private String messageId;

	public ReadMessage(String messageId) {
		super();
		this.messageId = messageId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the messagingProduct
	 */
	public String getMessagingProduct() {
		return messagingProduct;
	}
}
