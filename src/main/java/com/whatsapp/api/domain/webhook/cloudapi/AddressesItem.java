package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressesItem{

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
	private String type;

	public String getZip(){
		return zip;
	}

	public String getCountry(){
		return country;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public String getCity(){
		return city;
	}

	public String getStreet(){
		return street;
	}

	public String getState(){
		return state;
	}

	public String getType(){
		return type;
	}
}