package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.type.ButtonType;

/**
 * The type Phone number button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneNumberButton extends Button {
    @JsonProperty("phone_number")
    private String phoneNumber;

    /**
     * Instantiates a new Phone number button.
     *
     * @param text the text
     */
    protected PhoneNumberButton(String text) {
        super(ButtonType.PHONE_NUMBER, text);

    }

    /**
     * Instantiates a new Phone number button.
     */
    protected PhoneNumberButton() {

    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     * @return the phone number
     */
    public PhoneNumberButton setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
