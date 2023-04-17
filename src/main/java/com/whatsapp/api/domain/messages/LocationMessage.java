package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The type Template message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationMessage {

    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @return the LocationMessage
     */
    public LocationMessage setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude
     * @return LocationMessage
     */
    public LocationMessage setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude
     * @return LocationMessage
     */
    public LocationMessage setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address
     * @return LocationMessage
     */
    public LocationMessage setAddress(String address) {
        this.address = address;
        return this;
    }
}