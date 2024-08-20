package com.whatsapp.api.configuration;

public enum ApiVersion {

    @Deprecated()
    V16_0("v16.0"),
    V17_0("v17.0"),
    V18_0("v18.0"),
    V19_0("v19.0"),
    V20_0("v20.0");



    private final String value;

    ApiVersion(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
