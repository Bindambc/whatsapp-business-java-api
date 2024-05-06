package com.whatsapp.api;


import com.whatsapp.api.configuration.ApiVersion;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

/**
 * A factory for creating Whatsapp api client objects.
 */
public class WhatsappApiFactory {

    /**
     * Whatsapp token
     */
    final String token;

    /**
     * Create a new whatsapp api factory
     *
     * @param token the whatsapp token
     */
    private WhatsappApiFactory(String token) {
        this.token = token;
    }


    /**
     * New instance whatsapp api factory.
     *
     * @param apiKey the api key
     * @return the whatsapp api factory
     */
    public static WhatsappApiFactory newInstance(String apiKey) {
        return new WhatsappApiFactory(apiKey);
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business cloud api client
     *
     * @return the whatsapp business cloud api
     */
    public WhatsappBusinessCloudApi newBusinessCloudApi() {

        return new WhatsappBusinessCloudApi(token);
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business cloud api client, especifying the api version
     *
     * @return the whatsapp business cloud api
     */
    public WhatsappBusinessCloudApi newBusinessCloudApi(ApiVersion apiVersion) {

        return new WhatsappBusinessCloudApi(token, apiVersion);
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business management api client
     *
     * @return the whatsapp business management api
     */
    public WhatsappBusinessManagementApi newBusinessManagementApi() {
        return new WhatsappBusinessManagementApi(token);
    }

}
