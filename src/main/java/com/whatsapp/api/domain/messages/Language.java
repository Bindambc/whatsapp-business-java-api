package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.type.LanguageType;

/**
 * The type Language.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Language(LanguageType code) {
    /**
     * Instantiates a new Language.
     *
     * @param code the code
     */
    public Language {
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    @Override
    public LanguageType code() {
        return code;
    }
}
