package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object that allow messages to be replied
 * 
 * 
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/send-messages#replies">Replies</a>
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Context {

    @JsonProperty("message_id")
    private String messageId;

    /**
     * Gets messageId.
     *
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets messageId.
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
