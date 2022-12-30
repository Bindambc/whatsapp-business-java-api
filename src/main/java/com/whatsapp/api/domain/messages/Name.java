package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <b>Required</b>
 * <p>
 * Full contact name formatted as a name object. The object can contain the following fields:</p>
 * <ul>
 * <li><b>formatted_namestring</b> – Required. Full name, as it normally appears.</li>
 * <li><b>first_namestring</b> – Optional*. First name.</li>
 * <li><b>first_namestring</b> – Optional*. First name.</li>
 * <li><b>middle_namestring</b> – Optional*. Middle name.</li>
 * <li><b>suffixstring</b> – Optional*. Name suffix.</li>
 * <li><b>prefixstring</b> – Optional*. Name prefix.</li>
 * </ul>
 * *At least one of the optional parameters needs to be included along with the formatted_name parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public Name setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Name setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Name setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getSuffix() {
        return suffix;
    }

    public Name setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Name setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public Name setFormattedName(String formattedName) {
        this.formattedName = formattedName;
        return this;
    }
}