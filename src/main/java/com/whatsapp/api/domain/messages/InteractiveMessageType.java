package com.whatsapp.api.domain.messages;

public enum InteractiveMessageType {
    BUTTON("button"), //
    LIST("list"), //
    PRODUCT("product"), //
    PRODUCT_LIST("product_list");

    private final String value;

    InteractiveMessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
