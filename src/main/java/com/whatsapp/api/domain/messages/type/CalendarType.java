package com.whatsapp.api.domain.messages.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Calendar type.
 */
public enum CalendarType {

    /**
     * Gregorian calendar type.
     */
    GREGORIAN("GREGORIAN");

    private final String value;

    CalendarType(String value) {
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
