package com.whatsapp.api.domain.templates;

/**
 * Only applies to the HEADER type.
 *
 * @deprecated use {@link com.whatsapp.api.domain.templates.type.HeaderFormat} instead
 */
@Deprecated(forRemoval = true)
public enum HeaderFormat {
    /**
     * Text header format.
     */
    TEXT,
    /**
     * Image header format.
     */
    IMAGE,
    /**
     * Document header format.
     */
    DOCUMENT,
    /**
     * Video header format.
     */
    VIDEO
}
