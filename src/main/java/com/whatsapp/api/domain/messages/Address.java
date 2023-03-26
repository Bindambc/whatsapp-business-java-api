package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.AddressType;

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
public class Address {

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

    /**
     * Gets zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets zip.
     *
     * @param zip the zip code. Optional. ZIP code.
     * @return the zip
     */
    public Address setZip(String zip) {
        this.zip = zip;
        return this;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country Full country name.
     * @return the country
     */
    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Gets country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets country code.
     *
     * @param countryCode Optional. Two-letter country abbreviation.
     * @return the country code
     */
    public Address setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city Optional. City name.
     * @return the city
     */
    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street Optional. Street number and name.
     * @return the street
     */
    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state Optional. State abbreviation.
     * @return the state
     */
    public Address setState(String state) {
        this.state = state;
        return this;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public AddressType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type Optional. Standard values are HOME and WORK.
     * @return the type
     */
    public Address setType(AddressType type) {
        this.type = type;
        return this;
    }
}