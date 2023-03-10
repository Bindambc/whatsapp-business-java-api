package com.whatsapp.api.domain.phone.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Code method type.
 */
public enum CodeMethodType {

    /**
     * Sms code method type.
     */
    SMS("SMS"),
    /**
     * Voice code method type.
     */
    VOICE("VOICE");

    private final String value;


    CodeMethodType(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
