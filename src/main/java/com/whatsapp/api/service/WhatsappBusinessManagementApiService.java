package com.whatsapp.api.service;

import com.whatsapp.api.domain.config.CommerceDataItem;
import com.whatsapp.api.domain.config.GraphCommerceSettings;
import com.whatsapp.api.domain.phone.PhoneNumber;
import com.whatsapp.api.domain.phone.PhoneNumbers;
import com.whatsapp.api.domain.phone.RequestCode;
import com.whatsapp.api.domain.phone.VerifyCode;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import com.whatsapp.api.domain.templates.response.Template;
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
    Call<Template> createMessageTemplate(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Body MessageTemplate messageTemplate);

    /**
     * Update message template call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param messageTemplateId         the message template id
     * @param messageTemplate           the message template
     * @return the call
     */
    @POST("/" + API_VERSION + "/{whatsapp-business-account-ID}/message_templates/{message-template-id}")
    Call<Template> updateMessageTemplate(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Path("message-template-id") String messageTemplateId, @Body MessageTemplate messageTemplate);

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
    Call<PhoneNumber> retrievePhoneNumber(@Path("phone-number-ID") String phoneNumberId, @QueryMap Map<String, Object> queryParams);


    /**
     * Retrieve phone numbers call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @return the call
     */
    @GET("/" + API_VERSION + "/{whatsapp-business-account-ID}/phone_numbers")
    Call<PhoneNumbers> retrievePhoneNumbers(@Path("whatsapp-business-account-ID") String whatsappBusinessAccountId);

    /**
     * Request code call.
     *
     * @param phoneNumberId the phone number id
     * @param requestCode   the request code
     * @return the call
     */
    @POST("/" + API_VERSION + "/{phone-number-ID}/request_code")
    Call<Response> requestCode(@Path("phone-number-ID") String phoneNumberId, @Body RequestCode requestCode);

    /**
     * Verify code call.
     *
     * @param phoneNumberId the phone number id
     * @param verifyCode    the verify code
     * @return the call
     */
    @POST("/" + API_VERSION + "/{phone-number-ID}/verify_code")
    Call<Response> verifyCode(@Path("phone-number-ID") String phoneNumberId, @Body VerifyCode verifyCode);

    /**
     * Business phone number's whatsApp commerce settings call.
     *
     * @param phoneNumberId the phone number id
     * @param queryParams   the query params
     * @return the call
     */
    @GET("/" + API_VERSION + "/{phone-number-ID}/whatsapp_commerce_settings")
    Call<GraphCommerceSettings> getWhatsappCommerceSettings(@Path("phone-number-ID") String phoneNumberId, @QueryMap Map<String, String> queryParams);

    /**
     * Business phone number's whatsApp commerce settings call.
     *
     * @param phoneNumberId the phone number id
     * @param commerceDataItem the query params
     * @return the call
     */
    @POST("/" + API_VERSION + "/{phone-number-ID}/whatsapp_commerce_settings")
    Call<Response> updateWhatsappCommerceSettings(@Path("phone-number-ID") String phoneNumberId, @Body CommerceDataItem commerceDataItem);
}
