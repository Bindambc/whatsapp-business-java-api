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

    /**
     * Gets prefix.
     *
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets prefix.
     *
     * @param prefix Optional. Name prefix.
     * @return the prefix
     */
    public Name setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName Optional. Last name
     * @return the last name
     */
    public Name setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Gets middle name.
     *
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets middle name.
     *
     * @param middleName Optional. Middle name.
     * @return the middle name
     */
    public Name setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    /**
     * Gets suffix.
     *
     * @return the suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets suffix.
     *
     * @param suffix Optional. Name suffix
     * @return the suffix
     */
    public Name setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName Optional. First name.
     * @return the first name
     */
    public Name setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Gets formatted name.
     *
     * @return the formatted name
     */
    public String getFormattedName() {
        return formattedName;
    }

    /**
     * Sets formatted name.
     *
     * @param formattedName <b>Required</b>. Full name, as it normally appears.
     *                      At least one of the optional parameters needs to be included along with this.
     * @return the formatted name
     */
    public Name setFormattedName(String formattedName) {
        this.formattedName = formattedName;
        return this;
    }
}