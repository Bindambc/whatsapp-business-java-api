package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ParameterType {
    TEXT("text"), CURRENCY("currency"), DATE_TIME("date_time");

    private final String value;

    ParameterType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
