package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Language {
    private final com.whatsapp.api.domain.templates.Language code;

    public Language(com.whatsapp.api.domain.templates.Language code) {
        this.code = code;
    }

    public com.whatsapp.api.domain.templates.Language getCode() {
        return code;
    }
}
