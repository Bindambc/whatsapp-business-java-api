package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    @JsonProperty("address")
    private String address;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("name")
    private String name;

    @JsonProperty("longitude")
    private String longitude;

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public String getLongitude() {
        return longitude;
    }
}