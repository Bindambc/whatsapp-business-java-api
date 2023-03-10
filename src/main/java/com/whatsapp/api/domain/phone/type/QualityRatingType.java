package com.whatsapp.api.domain.phone.type;

import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonValue
    public String getValue() {
        return value;
    }
}
