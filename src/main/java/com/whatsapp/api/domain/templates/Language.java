package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Supported Languages for message templates
 * <a href="https://developers.facebook.com/docs/whatsapp/api/messages/message-templates/#supported-languages">See more</a>
 */
//TODO: add another supported languages
public enum Language {
    /**
     * Chinese (CHN) China
     */
    ZH_CN("zh_CN"),
    /**
     * Chinese (HKG)
     */
    ZH_HK("zh_HK"),
    /**
     * Chinese (TAI)
     */
    ZH_TW("zh_TW"),//
    /**
     * English
     */
    EN("en"),
    /**
     * English (UK)
     */
    EN_GB("en_GB"),
    /**
     * English (US)
     */
    EN_US("en_US"), //
    /**
     * Portuguese (BR) Brazil
     */
    PT_BR("pt_BR"),
    /**
     * Portuguese (POR)
     */
    PT_PT("pt_PT"),  //
    /**
     * Spanish
     */
    ES("es"),
    /**
     * Spanish (ARG)
     */
    ES_AR("es_AR"),
    /**
     * Spanish (SPA)
     */
    ES_ES("es_ES"),
    /**
     * Spanish (MEX)
     */
    ES_MX("es_MX");

    private final String value;

    Language(String value) {
        this.value = value;
    }
    @JsonValue
    public String getValue() {
        return value;
    }
}
