package com.whatsapp.api.domain.templates.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Supported Languages for message templates
 * <a href="https://developers.facebook.com/docs/whatsapp/api/messages/message-templates/#supported-languages">See more</a>
 */

public enum LanguageType {

    /**
     * Afrikaans af
     */
    AF("af"),
    /**
     * Albanian sq
     */
    SQ("sq"),
    /**
     * Arabic ar
     */
    AR("ar"),
    /**
     * Azerbaijani az
     */
    AZ("az"),
    /**
     * Bengali bn
     */
    BN("bn"),
    /**
     * Bulgarian bg
     */
    BG("bg"),
    /**
     * Catalan ca
     */
    CA("ca"),
    /**
     * Chinese (CHN) zh_CN
     */
    ZH_CN("zh_CN"),
    /**
     * Chinese (HKG) zh_HK
     */
    ZH_HK("zh_HK"),
    /**
     * Chinese (TAI) zh_TW
     */
    ZH_TW("zh_TW"),
    /**
     * Croatian hr
     */
    HR("hr"),
    /**
     * Czech cs
     */
    CS("cs"),
    /**
     * Danish da
     */
    DA("da"),
    /**
     * Dutch nl
     */
    NL("nl"),
    /**
     * English en
     */
    EN("en"),
    /**
     * English (UK) en_GB
     */
    EN_GB("en_GB"),
    /**
     * English (US) en_US
     */
    EN_US("en_US"),
    /**
     * Estonian et
     */
    ET("et"),
    /**
     * Filipino fil
     */
    FIL("fil"),
    /**
     * Finnish fi
     */
    FI("fi"),
    /**
     * French fr
     */
    FR("fr"),
    /**
     * Georgian ka
     */
    KA("ka"),
    /**
     * German de
     */
    DE("de"),
    /**
     * Greek el
     */
    EL("el"),
    /**
     * Gujarati gu
     */
    GU("gu"),
    /**
     * Hausa ha
     */
    HA("ha"),
    /**
     * Hebrew he
     */
    ha("he"),
    /**
     * Hindi hi
     */
    HI("hi"),
    /**
     * Hungarian hu
     */
    HU("hu"),
    /**
     * Indonesian id
     */
    ID("id"),
    /**
     * Irish ga
     */
    GA("ga"),
    /**
     * Italian it
     */
    IT("it"),
    /**
     * Japanese ja
     */
    JA("ja"),
    /**
     * Kannada kn
     */
    KN("kn"),
    /**
     * Kazakh kk
     */
    KK("kk"),
    /**
     * Kinyarwanda rw_RW
     */
    RW_RW("rw_RW"),
    /**
     * Korean ko
     */
    KO("ko"),
    /**
     * Kyrgyz (Kyrgyzstan) ky_KG
     */
    KY_KG("ky_KG"),
    /**
     * Lao lo
     */
    LO("lo"),
    /**
     * Latvian lv
     */
    LV("lv"),
    /**
     * Lithuanian lt
     */
    LT("lt"),
    /**
     * Macedonian mk
     */
    MK("mk"),
    /**
     * Malay ms
     */
    MS("ms"),
    /**
     * Malayalam ml
     */
    ML("ml"),
    /**
     * Marathi mr
     */
    MR("mr"),
    /**
     * Norwegian nb
     */
    NB("nb"),
    /**
     * Persian fa
     */
    FA("fa"),
    /**
     * Polish pl
     */
    PL("pl"),
    /**
     * Portuguese (BR) pt_BR
     */
    PT_BR("pt_BR"),
    /**
     * Portuguese (POR) pt_PT
     */
    PT_PT("pt_PT"),
    /**
     * Punjabi pa
     */
    PA("pa"),
    /**
     * Romanian ro
     */
    RO("ro"),
    /**
     * Russian ru
     */
    RU("ru"),
    /**
     * Serbian sr
     */
    SR("sr"),
    /**
     * Slovak sk
     */
    SK("sk"),
    /**
     * Slovenian sl
     */
    SL("sl"),
    /**
     * Spanish es
     */
    ES("es"),
    /**
     * Spanish (ARG) es_AR
     */
    ES_AR("es_AR"),
    /**
     * Spanish (SPA) es_ES
     */
    ES_ES("es_ES"),
    /**
     * Spanish (MEX) es_MX
     */
    ES_MX("es_MX"),
    /**
     * Swahili sw
     */
    SW("sw"),
    /**
     * Swedish sv
     */
    SV("sv"),
    /**
     * Tamil ta
     */
    TA("ta"),
    /**
     * Telugu te
     */
    TE("te"),
    /**
     * Thai th
     */
    TH("th"),
    /**
     * Turkish tr
     */
    TR("tr"),
    /**
     * Ukrainian uk
     */
    UK("uk"),
    /**
     * Urdu ur
     */
    UR("ur"),
    /**
     * Uzbek uz
     */
    UZ("uz"),
    /**
     * Vietnamese vi
     */
    VI("vi"),
    /**
     * Zulu zu
     */
    ZU("zu");


    private final String value;

    LanguageType(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
