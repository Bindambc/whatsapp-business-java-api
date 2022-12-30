package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Org{

	@JsonProperty("company")
	private String company;

	@JsonProperty("department")
	private String department;

	@JsonProperty("title")
	private String title;

	public String getCompany(){
		return company;
	}

	public String getDepartment(){
		return department;
	}

	public String getTitle(){
		return title;
	}
}