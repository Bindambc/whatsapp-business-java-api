package com.whatsapp.api.configuration;

public class WhatsappApiConfig {

    public static  String BASE_DOMAIN = "https://graph.facebook.com/";

    public final static  String API_VERSION = "v14.0";

    public static void setBaseDomain(String baseDomain) {
        BASE_DOMAIN = baseDomain;
    }


}
