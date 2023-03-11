package com.whatsapp.api.domain.phone.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Quality rating type.
 */
public enum QualityRatingType {
    /**
     * High Quality
     */
    GREEN("GREEN"),
    /**
     * Medium Quality
     */
    YELLOW("YELLOW"),
    /**
     * Low Quality
     */
    RED("RED"),
    /**
     * Quality has not been determined
     */
    NA("NA");

    private final String value;

    QualityRatingType(String value) {
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
