package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contact organization information formatted as an org object.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Org {

    @JsonProperty("company")
    private String company;

    @JsonProperty("department")
    private String department;

    @JsonProperty("title")
    private String title;

    /**
     * Gets company.
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets company.
     *
     * @param company Optional. Name of the contact's company.
     * @return the company
     */
    public Org setCompany(String company) {
        this.company = company;
        return this;
    }

    /**
     * Gets department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets department.
     *
     * @param department Optional. Name of the contact's department.
     * @return the department
     */
    public Org setDepartment(String department) {
        this.department = department;
        return this;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title Optional. Contact's business title.
     * @return the title
     */
    public Org setTitle(String title) {
        this.title = title;
        return this;
    }
}