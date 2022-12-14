package com.whatsapp.api.domain.messages;

public enum AddressType {
    HOME("HOME"), WORK("WORK");

    private final String value;

    AddressType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
