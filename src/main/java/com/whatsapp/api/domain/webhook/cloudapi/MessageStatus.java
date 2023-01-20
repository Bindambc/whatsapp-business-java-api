package com.whatsapp.api.domain.webhook.cloudapi;


import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageStatus {
    /**
     * Message received by WhatsApp server. (One checkmark)
     */
    SENT("sent"),
    /**
     * Message delivered to the recipient. (Two checkmarks)
     */
    DELIVERED("delivered"),
    /**
     * Message read by recipient. (Two blue checkmarks)
     */
    READ("read"),

    /**
     * Message failed to send.(Red error triangle)
     */
    FAILED("failed"),
    /**
     * Message deleted by the user. (	Message is replaced in WhatsApp mobile with the note "This message was deleted".)
     */
    DELETED("deleted");

    private final String value;

    MessageStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
