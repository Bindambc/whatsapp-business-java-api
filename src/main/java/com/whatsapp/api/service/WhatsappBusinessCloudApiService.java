package com.whatsapp.api.service;


import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.whatsapp.api.configuration.WhatsappApiConfig.API_VERSION;


/**
 * The interface Whatsapp business cloud api service.
 */
public interface WhatsappBusinessCloudApiService {


    /**
     * Send message call.
     *
     * @param phoneNumberId the phone number id
     * @param message       the message
     * @return the call
     */
    @POST("/" + API_VERSION + "/{Phone-Number-ID}/messages")
    Call<MessageResponse> sendMessage(@Path("Phone-Number-ID") String phoneNumberId, @Body Message message);

}
