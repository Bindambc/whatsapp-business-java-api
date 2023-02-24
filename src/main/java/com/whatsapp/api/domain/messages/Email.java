package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.AddressType;

/**
 * <b>Optional</b>
 * <p>
 * Contact email address(es) formatted as an emails object. The object can contain the following fields:
 * </p>
 * - emailstring – Optional. Email address.
 * <p>
 * - typestring – Optional. Standard values are HOME and WORK.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email {

    @JsonProperty("type")
    private AddressType type;

    @JsonProperty("email")
    private String email;

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
     * @param type the type
     * @return the type
     */
    public Email setType(AddressType type) {
        this.type = type;
        return this;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     * @return the email
     */
    public Email setEmail(String email) {
        this.email = email;
        return this;
    }
}