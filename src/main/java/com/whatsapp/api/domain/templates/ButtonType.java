package com.whatsapp.api.domain.templates;

/**
 * The enum Button type.
 *
 * @deprecated use {@link com.whatsapp.api.domain.messages.type.ButtonType} instead
 */
@Deprecated(forRemoval = true)
public enum ButtonType {
    /**
     * Phone number button type.
     */
    PHONE_NUMBER,
    /**
     * Url button type.
     */
    URL,
    /**
     * Quick reply button type.
     */
    QUICK_REPLY
}
