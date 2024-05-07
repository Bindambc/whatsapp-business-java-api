package com.whatsapp.api.domain.phone.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Level type.
 */
public enum LevelType
{

    /**
     * Standard Level type.
     */
    STANDARD("STANDARD"),
    /**
     * High Level type.
     */
    HIGH("HIGH"),
    NOT_APPLICABLE("NOT_APPLICABLE");

    private final String value;

    LevelType(String value)
    {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue()
    {
        return value;
    }
}
