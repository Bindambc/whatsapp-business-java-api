package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The type Language.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Language {
    private final com.whatsapp.api.domain.templates.Language code;

    /**
     * Instantiates a new Language.
     *
     * @param code the code
     */
    public Language(com.whatsapp.api.domain.templates.Language code) {
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public com.whatsapp.api.domain.templates.Language getCode() {
        return code;
    }
}
