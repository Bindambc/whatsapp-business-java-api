package com.whatsapp.api.domain.messages.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Component type.
 */
public enum ComponentType {
    /**
     * Body component type.
     */
    BODY("body"),
    /**
     * Header component type.
     */
    HEADER("header"),


    /**
     * Button component type.
     */
    BUTTON("button");

    private final String value;

    ComponentType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
