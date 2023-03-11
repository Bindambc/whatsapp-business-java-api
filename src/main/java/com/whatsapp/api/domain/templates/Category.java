package com.whatsapp.api.domain.templates;

/**
 * <b>Required.</b> The type of message template.
 * Values: TRANSACTIONAL, MARKETING, OTP
 *
 * @deprecated use {@link com.whatsapp.api.domain.templates.type.Category} instead
 */
@Deprecated(forRemoval = true)
public enum Category {
    /**
     * Transactional category.
     */
    TRANSACTIONAL,
    /**
     * Marketing category.
     */
    MARKETING,
    /**
     * Otp category.
     */
    OTP
}
