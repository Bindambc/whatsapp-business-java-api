package com.whatsapp.api.service;

import com.whatsapp.api.domain.phone.PhoneNumber;
import com.whatsapp.api.domain.phone.PhoneNumbers;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

import static com.whatsapp.api.configuration.WhatsappApiConfig.API_VERSION;

/**
 * The interface Whatsapp business management api service.
 */
public interface WhatsappBusinessManagementApiService {


    /**
     * Create message template call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param messageTemplate           the message template
     * @return the call
     */
    @POST("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplateIDResponse> createMessageTemplate(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Body MessageTemplate messageTemplate);

    /**
     * Update message template call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param messageTemplateId         the message template id
     * @param messageTemplate           the message template
     * @return the call
     */
    @POST("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates/{message-template-id}")
    Call<MessageTemplateIDResponse> updateMessageTemplate(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Path("message-template-id") String messageTemplateId, @Body MessageTemplate messageTemplate);

    /**
     * Delete message template call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param name                      the name
     * @return the call
     */
    @DELETE("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates")
    Call<Response> deleteMessageTemplate(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Query("name") String name);

    /**
     * Retrieve templates call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @return the call
     */
    @GET("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplates> retrieveTemplates(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId);

    /**
     * Retrieve templates call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param filters                   the filters
     * @return the call
     */
    @GET("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplates> retrieveTemplates(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @QueryMap Map<String, Object> filters);


    /**
     * Retrieve phone number call.
     *
     * @param phoneNumberId the phone number id
     * @param queryParams   the query params
     * @return the call
     */
    @GET("/" + API_VERSION + "/{phone-number-ID}")
    Call<PhoneNumber> retrievePhoneNumber( @Path("phone-number-ID") String phoneNumberId, @QueryMap Map<String, Object> queryParams);


    /**
     * Retrieve phone numbers call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @return the call
     */
    @GET("/" + API_VERSION + "/{whatsapp-business-account-ID}/phone_numbers")
    Call<PhoneNumbers> retrievePhoneNumbers(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId);


}
