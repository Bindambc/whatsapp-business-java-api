package com.whatsapp.api.domain.webhook;

/**
 * Used when an event happened in a specific WABA.
 * See <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/webhooks/components">Webhooks Components</a>
 */
public enum EventType {

    DISABLED_UPDATE, //
    VERIFIED_ACCOUNT,//
    /**
     * Used to report that a restriction has been put in place when a WABA violates WhatsApp Business Platform policies.
     */
    ACCOUNT_RESTRICTION,//

    ONBOARDING, UPGRADE, DOWNGRADE, FLAGGED, UNFLAGGED,
    /**
     * The review was approved. If a business was previously unable to download their certificate, that business should now be able to use their display name by downloading the certificate.
     */
    APPROVED, //
    IN_APPEAL, //
    PENDING,//
    /**
     * The review was rejected, with the given rejection reason. If a business was previously unable to download their certificate, that business needs to reapply for a display name review to get access to the certificate. If a business is already using their certificate, the display name review rejection does not affect their operation. However, passing the review is necessary for the business to grow its message and account limits.
     */
    REJECTED, //
    DISABLED, //
    REINSTATED,//
    /**
     * The review is deferred and the business can use their display name by downloading the certificate.
     */
    DEFERRED,

    PIN_RESET_REQUEST,

    PIN_RESET_SUCCESS,

    PIN_CHANGED

}
