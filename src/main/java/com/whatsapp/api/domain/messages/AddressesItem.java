package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Optional.
 * <p>
 * Full contact address(es) formatted as an addresses object. The object can contain the following fields:
 * <p>
 * streetstring – Optional. Street number and name.
 * <p>
 * citystring – Optional. City name.
 * <p>
 * statestring – Optional. State abbreviation.
 * <p>
 * zipstring – Optional. ZIP code.
 * <p>
 * countrystring – Optional. Full country name.
 * <p>
 * country_codestring – Optional. Two-letter country abbreviation.
 * <p>
 * typestring – Optional. Standard values are HOME and WORK.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressesItem {

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("country")
    private String country;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("city")
    private String city;

    @JsonProperty("street")
    private String street;

    @JsonProperty("state")
    private String state;

    @JsonProperty("type")
    private AddressType type;

    public String getZip() {
        return zip;
    }

    public AddressesItem setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public AddressesItem setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public AddressesItem setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressesItem setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressesItem setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getState() {
        return state;
    }

    public AddressesItem setState(String state) {
        this.state = state;
        return this;
    }

    public AddressType getType() {
        return type;
    }

    public AddressesItem setType(AddressType type) {
        this.type = type;
        return this;
    }
}