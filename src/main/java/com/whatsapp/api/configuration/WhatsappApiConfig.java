package com.whatsapp.api.configuration;

/**
 * The type Whatsapp api config.
 */
public class WhatsappApiConfig {

    /**
     * The constant API_VERSION.
     */
    public final static String API_VERSION = "v16.0";
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


}
