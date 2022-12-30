package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {

    @JsonProperty("prefix")
    private String prefix;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("suffix")
    private String suffix;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("formatted_name")
    private String formattedName;

    public String getPrefix() {
        return prefix;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFormattedName() {
        return formattedName;
    }
}