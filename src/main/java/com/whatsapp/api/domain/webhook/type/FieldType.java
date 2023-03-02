package com.whatsapp.api.domain.webhook.type;

import com.fasterxml.jackson.annotation.JsonValue;


/**
 * The enum Field type.
 */
public enum FieldType {
    /**
     * Notifies you when the message template status changes, by being approved or rejected, or if it has been disabled.
     */
    MESSAGE_TEMPLATE_STATUS_UPDATE("message_template_status_update"),
    /**
     * Notifies you when the name review associated with a phone number has a status update.
     */
    PHONE_NUMBER_NAME_UPDATE("phone_number_name_update"),
    /**
     * Notifies you when the quality-related status of a phone number has an update.
     */
    PHONE_NUMBER_QUALITY_UPDATE("phone_number_quality_update"),
    /**
     * Notifies you when a WABA has been upgraded from unverified trial experience to a verified account, or if a WABA has been banned.
     */
    ACCOUNT_UPDATE("account_update"),
    /**
     * Notifies you when a WABA has been reviewed.
     */
    ACCOUNT_REVIEW_UPDATE("account_review_update"),
    /**
     * Notifies you about messages
     */
    MESSAGES("messages"),
    /**
     * A notification is sent to you when:
     * <ul> <li>you request to disable two-step verification code</li>
     *  <li>the two-step verification code is disabled</li>
     *  <li>the two-step verification code is updated</li>
     * </ul>
     */
    security("security");

    private final String value;

    FieldType(String value) {
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
