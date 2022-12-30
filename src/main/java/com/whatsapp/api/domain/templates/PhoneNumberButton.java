package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneNumberButton extends Button {
    @JsonProperty("phone_number")
    private String phoneNumber;

    protected PhoneNumberButton(String text) {
        super(ButtonType.PHONE_NUMBER, text);

    }

    protected PhoneNumberButton() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberButton setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
