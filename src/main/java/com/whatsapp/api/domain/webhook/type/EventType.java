package com.whatsapp.api.domain.webhook.type;

/**
 * Used when an event happened in a specific WABA.
 * See <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/webhooks/components">Webhooks Components</a>
 */
public enum EventType {

    /**
     * Disabled update event type.
     */
    DISABLED_UPDATE, //
    /**
     * Verified account event type.
     */
    VERIFIED_ACCOUNT,//
    /**
     * Used to report that a restriction has been put in place when a WABA violates WhatsApp Business Platform policies.
     */
    ACCOUNT_RESTRICTION,//

    /**
     * Onboarding event type.
     */
    ONBOARDING,
    /**
     * Upgrade event type.
     */
    UPGRADE,
    /**
     * Downgrade event type.
     */
    DOWNGRADE,
    /**
     * Flagged event type.
     */
    FLAGGED,
    /**
     * Unflagged event type.
     */
    UNFLAGGED,
    /**
     * The review was approved. If a business was previously unable to download their certificate, that business should now be able to use their display name by downloading the certificate.
     */
    APPROVED, //
    /**
     * In appeal event type.
     */
    IN_APPEAL, //
    /**
     * Pending event type.
     */
    PENDING,//
    /**
     * The review was rejected, with the given rejection reason. If a business was previously unable to download their certificate, that business needs to reapply for a display name review to get access to the certificate. If a business is already using their certificate, the display name review rejection does not affect their operation. However, passing the review is necessary for the business to grow its message and account limits.
     */
    REJECTED, //
    /**
     * Disabled event type.
     */
    DISABLED, //
    /**
     * Reinstated event type.
     */
    REINSTATED,//
    /**
     * The review is deferred and the business can use their display name by downloading the certificate.
     */
    DEFERRED,

    /**
     * Pin reset request event type.
     */
    PIN_RESET_REQUEST,

    /**
     * Pin reset success event type.
     */
    PIN_RESET_SUCCESS,

    /**
     * Pin changed event type.
     */
    PIN_CHANGED

}
