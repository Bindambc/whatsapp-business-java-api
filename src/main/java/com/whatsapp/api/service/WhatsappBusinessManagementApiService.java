package com.whatsapp.api.service;

import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.response.MessageTemplateSuccessResponse;
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

public interface WhatsappBusinessManagementApiService {


    @POST("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplateIDResponse> createMessageTemplate(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Body MessageTemplate messageTemplate);

    @POST("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates/{message-template-id}")
    Call<MessageTemplateIDResponse> updateMessageTemplate(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Path("message-template-id") String messageTemplateId, @Body MessageTemplate messageTemplate);

    @DELETE("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplateSuccessResponse> deleteMessageTemplate(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Query("name") String name);

    @GET("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplates> retrieveTemplates(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId);

    @GET("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplates> retrieveTemplates(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @QueryMap Map<String, Object> filters);

}
