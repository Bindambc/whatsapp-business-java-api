package com.whatsapp.api.impl;

import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.service.WhatsappBusinessCloudApiService;

import static com.whatsapp.api.WhatsappApiServiceGenerator.createService;
import static com.whatsapp.api.WhatsappApiServiceGenerator.executeSync;

/**
 * Implementation of WhatsApp Business Platform Cloud API with synchronous/blocking
 * method calls.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api">WhatsApp Business Platform Cloud API</a>
 */
public class WhatsappBusinessCloudApi {

    private final WhatsappBusinessCloudApiService whatsappBusinessCloudApiService;


    /**
     * Instantiates a new Whatsapp business cloud api.
     *
     * @param token the token
     */
    public WhatsappBusinessCloudApi(String token) {
        this.whatsappBusinessCloudApiService = createService(WhatsappBusinessCloudApiService.class, token);

    }

    /**
     * Use this endpoint to send text, media, contacts, location, and interactive messages,
     * as well as message templates to your customers.
     *
     * @param phoneNumberId Represents a specific phone number.
     * @param message       The {@link Message} object.
     * @return {@link MessageResponse}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages">official documentation</a>
     */
    public MessageResponse sendMessage(String phoneNumberId, Message message) {

        return executeSync(whatsappBusinessCloudApiService.sendMessage(phoneNumberId, message));
    }

}
