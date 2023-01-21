package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Org {

    @JsonProperty("company")
    private String company;

    @JsonProperty("department")
    private String department;

    @JsonProperty("title")
    private String title;

    public String getCompany() {
        return company;
    }

    public Org setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Org setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Org setTitle(String title) {
        this.title = title;
        return this;
    }
}