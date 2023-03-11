package com.whatsapp.api.domain.webhook;

/**
 * The enum Restriction type.
 *
 * @deprecated use {@link com.whatsapp.api.domain.webhook.type.RestrictionType} instead
 */
@Deprecated(forRemoval = true)
public enum RestrictionType {
    /**
     * Restricted add phone number action restriction type.
     */
    RESTRICTED_ADD_PHONE_NUMBER_ACTION,
    /**
     * Restricted biz initiated messaging restriction type.
     */
    RESTRICTED_BIZ_INITIATED_MESSAGING,
    /**
     * Restricted customer initiated messaging restriction type.
     */
    RESTRICTED_CUSTOMER_INITIATED_MESSAGING
}
