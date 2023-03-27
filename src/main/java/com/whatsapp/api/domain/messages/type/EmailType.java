package com.whatsapp.api.domain.messages.type;

/**
 * The enum Address type.
 */
public enum EmailType {

    /**
     * Home email type.
     */
    HOME("HOME"),

    /**
     * Work email type.
     */
    WORK("WORK");

    private final String value;

    EmailType(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
