package com.whatsapp.api.domain.templates.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <b>Required.</b> The type of message template.
 */
public enum Category {

    /**
     * Authentication category. Valid category value for whatsapp cloud Api v16.0 and later requests
     */
    AUTHENTICATION("AUTHENTICATION"),

    /**
     * Utility category. Valid category value for whatsapp cloud Api v16.0 and later requests
     */
    UTILITY("UTILITY"),

    /**
     * Transactional category.
     * Valid category value for whatsapp cloud Api v15.0 and older requests, until May 1, 2023
     */
    @Deprecated() TRANSACTIONAL("TRANSACTIONAL"),

    /**
     * Marketing category. Valid category value for whatsapp cloud Api v16.0 and older requests
     */
    MARKETING("MARKETING"),
    /**
     * Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     * Otp category.
     */
    @Deprecated() OTP("OTP"),

    /**
     * Account update category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() ACCOUNT_UPDATE("ACCOUNT_UPDATE"),
    /**
     * Payment update category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() PAYMENT_UPDATE("PAYMENT_UPDATE"),
    /**
     * Personal finance update category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() PERSONAL_FINANCE_UPDATE("PERSONAL_FINANCE_UPDATE"),
    /**
     * Shipping update category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() SHIPPING_UPDATE("SHIPPING_UPDATE"),
    /**
     * Reservation update category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() RESERVATION_UPDATE("RESERVATION_UPDATE"),
    /**
     * Issue resolution category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() ISSUE_RESOLUTION("ISSUE_RESOLUTION"),
    /**
     * Appointment update category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() APPOINTMENT_UPDATE("APPOINTMENT_UPDATE"),
    /**
     * Transportation update category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() TRANSPORTATION_UPDATE("TRANSPORTATION_UPDATE"),
    /**
     * Ticket update category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() TICKET_UPDATE("TICKET_UPDATE"),
    /**
     * Alert update category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() ALERT_UPDATE("ALERT_UPDATE"),
    /**
     * Auto reply category. Valid category value for whatsapp cloud api v15.0 and older requests, until May 1, 2023.
     */
    @Deprecated() AUTO_REPLY("AUTO_REPLY");


    private final String value;


    Category(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
