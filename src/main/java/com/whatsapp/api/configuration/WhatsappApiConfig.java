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
    public static String API_VERSION = ApiVersion.V19_0.getValue();
    /**
     * The constant BASE_DOMAIN.
     */
    public static String BASE_DOMAIN = "https://graph.facebook.com/";

    /**
     * Sets base domain.
     *
     * @param baseDomain the base domain
     */
    public static void setBaseDomain(String baseDomain) {
        BASE_DOMAIN = baseDomain;
    }

    /**
     * Sets api version.
     *
     * @param apiVersion the api version enum
     */
    public static void setApiVersion(ApiVersion apiVersion) {
        API_VERSION = apiVersion.getValue();
    }


}
