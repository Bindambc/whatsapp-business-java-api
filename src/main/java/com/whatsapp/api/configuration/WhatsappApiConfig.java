package com.whatsapp.api.configuration;

/**
 * The type Whatsapp api config.
 */
public class WhatsappApiConfig {


    private WhatsappApiConfig() {
    }

    /**
     * The constant API_VERSION.
     */
    private static ApiVersion apiVersion = ApiVersion.V19_0;
    /**
     * The constant BASE_DOMAIN.
     */
    private static String baseDomain = "https://graph.facebook.com/";

    /**
     * Sets base domain.
     *
     * @param baseDomain the base domain
     */
    public static void setBaseDomain(String baseDomain) {
        WhatsappApiConfig.baseDomain = baseDomain;
    }

    /**
     * Sets api version.
     *
     * @param apiVersion the api version enum
     */
    public static void setApiVersion(ApiVersion apiVersion) {
        WhatsappApiConfig.apiVersion = apiVersion;
    }

    /**
     * Gets api version
     *
     * @return apiVersion
     */
    public static ApiVersion getApiVersion() {
        return apiVersion;
    }

    /**
     * Gets api version
     *
     * @return apiVersion
     */
    public static String getBaseDomain() {
        return baseDomain;
    }


}
