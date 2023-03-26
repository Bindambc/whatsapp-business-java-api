package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.PhoneType;

/**
 * <b>Optional.</b>
 * <p>
 * Contact phone number(s) formatted as a phone object. The object can contain the following fields:</p>
 * <ul>
 * <li><b>phone</b> – Optional. Automatically populated with the `wa_id` value as a formatted phone number.</li>
 * <li><b>type</b> – Optional. Standard Values are CELL, MAIN, IPHONE, HOME, and WORK.</li>
 * <li><b>wa_id</b> – Optional. WhatsApp ID.</li>
 * </ul>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Phone {

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("wa_id")
    private String waId;

    @JsonProperty("type")
    private PhoneType type;

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone Optional. Automatically populated with the `wa_id` value as a formatted phone number.
     * @return the phone
     */
    public Phone setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Gets wa id.
     *
     * @return the wa id
     */
    public String getWaId() {
        return waId;
    }

    /**
     * Sets wa id.
     *
     * @param waId Optional. WhatsApp ID.
     * @return the wa id
     */
    public Phone setWaId(String waId) {
        this.waId = waId;
        return this;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public PhoneType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type Optional. Standard Values are CELL, MAIN, IPHONE, HOME, and WORK.
     * @return the type
     */
    public Phone setType(PhoneType type) {
        this.type = type;
        return this;
    }
}