package com.whatsapp.api.domain.messages.type;

/**
 * The enum Url type.
 */
public enum UrlType {
    /**
     * Home url type.
     */
    HOME("HOME"),
    /**
     * Work url type.
     */
    WORK("WORK");

    private final String value;

    UrlType(String value) {
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
