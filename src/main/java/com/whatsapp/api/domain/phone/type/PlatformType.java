package com.whatsapp.api.domain.phone.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Platform type.
 */
public enum PlatformType
{

    /**
     * Cloud API Platform type.
     */
    CLOUD_API("CLOUD_API"),
    /**
     * On-Premises API Platform type.
     */
    ON_PREMISE("ON_PREMISE"),
    NOT_APPLICABLE("NOT_APPLICABLE");

    private final String value;

    PlatformType(String value)
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
