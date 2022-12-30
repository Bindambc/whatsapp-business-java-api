package com.whatsapp.api;


import com.whatsapp.api.impl.WhatsappBusinessCloudApi;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

/**
 * A factory for creating Whatsapp api client objects.
 */
public class WhatsappApiFactory {

    /**
     * Whatsapp token
     */
    String token;

    /**
     * Create a new whatsapp api factory
     *
     * @param token the whatsapp token
     */
    private WhatsappApiFactory(String token) {
        this.token = token;
    }


    public static WhatsappApiFactory newInstance(String apiKey) {
        return new WhatsappApiFactory(apiKey);
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business cloud api client
     */
    public WhatsappBusinessCloudApi newBusinessCloudApi() {

        return new WhatsappBusinessCloudApi(token);
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business management api client
     */
    public WhatsappBusinessManagementApi newBusinessManagementApi() {
        return new WhatsappBusinessManagementApi(token);
    }

}
