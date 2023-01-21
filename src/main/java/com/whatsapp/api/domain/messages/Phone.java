package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <b>Optional.</b>
 * <p>
 * Contact phone number(s) formatted as a phone object. The object can contain the following fields:</p>
 * <ul>
 * <li><b>phonestring</b> – Optional. Automatically populated with the `wa_id` value as a formatted phone number.</li>
 * <li><b>typestring</b> – Optional. Standard Values are CELL, MAIN, IPHONE, HOME, and WORK.</li>
 * <li><b>wa_idstring</b> – Optional. WhatsApp ID.</li>
 * </ul>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Phone {

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("wa_id")
    private String waId;

    @JsonProperty("type")
    private AddressType type;

    public String getPhone() {
        return phone;
    }

    public Phone setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getWaId() {
        return waId;
    }

    public Phone setWaId(String waId) {
        this.waId = waId;
        return this;
    }

    public AddressType getType() {
        return type;
    }

    public Phone setType(AddressType type) {
        this.type = type;
        return this;
    }
}