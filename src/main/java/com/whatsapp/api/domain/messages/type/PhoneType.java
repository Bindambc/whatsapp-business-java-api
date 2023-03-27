package com.whatsapp.api.domain.messages.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Phone type.
 */
public enum PhoneType {
    /**
     * Cell phone type.
     */
    CELL("CELL"),
    /**
     * Main phone type.
     */
    MAIN("MAIN"),

    /**
     * Iphone phone type.
     */
    IPHONE("IPHONE"),
    /**
     * Home phone type.
     */
    HOME("HOME"),

    /**
     * Work phone type.
     */
    WORK("WORK");

    private final String value;

    PhoneType(String value) {
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
