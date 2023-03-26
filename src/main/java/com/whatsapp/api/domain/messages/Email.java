package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.EmailType;

/**
 * <b>Optional</b>
 * <p>
 * Contact email address(es) formatted as an emails object. The object can contain the following fields:
 * </p>
 * - email – Optional. Email address.
 * <p>
 * - type – Optional. Standard values are HOME and WORK.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email {

    @JsonProperty("type")
    private EmailType type;

    @JsonProperty("email")
    private String email;

    /**
     * Instantiates a new Email.
     */
    public Email() {
    }

    /**
     * Instantiates a new Email.
     *
     * @param type  the type. Optional. Standard values are HOME and WORK.
     * @param email the email
     */
    public Email(EmailType type, String email) {
        this.type = type;
        this.email = email;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public EmailType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type. Optional. Standard values are HOME and WORK.
     * @return the type
     */
    public Email setType(EmailType type) {
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