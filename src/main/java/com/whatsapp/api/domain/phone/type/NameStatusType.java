package com.whatsapp.api.domain.phone.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Name status type.
 */
public enum NameStatusType {

    /**
     * The name has been approved. You can download your certificate now.
     */
    APPROVED("APPROVED"),
    /**
     * The certificate for the phone is available and display name is ready to use without review.
     */
    AVAILABLE_WITHOUT_REVIEW("AVAILABLE_WITHOUT_REVIEW"),
    /**
     * The name has not been approved. You cannot download your certificate.
     */
    DECLINED("DECLINED"),
    /**
     * Your certificate has expired and can no longer be downloaded.
     */
    EXPIRED("EXPIRED"),

    /**
     * Your name request is under review. You cannot download your certificate.
     */
    PENDING_REVIEW("PENDING_REVIEW"),

    /**
     * No certificate is available.
     */
    NONE("NONE");

    private final String value;

    NameStatusType(String value) {
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
