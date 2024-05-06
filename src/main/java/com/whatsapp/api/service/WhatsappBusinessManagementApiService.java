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
import retrofit2.http.*;

import java.util.Map;

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
    @POST("/{api-version}/{whatsapp-business-account-ID}/message_templates")
    Call<Template> createMessageTemplate(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Body MessageTemplate messageTemplate);

    /**
     * Update message template call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param messageTemplateId         the message template id
     * @param messageTemplate           the message template
     * @return the call
     */
    @POST("/{api-version}/{whatsapp-business-account-ID}/message_templates/{message-template-id}")
    Call<Template> updateMessageTemplate(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Path("message-template-id") String messageTemplateId, @Body MessageTemplate messageTemplate);

    /**
     * Delete message template call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param name                      the name
     * @return the call
     */
    @DELETE("/{api-version}/{whatsapp-business-account-ID}/message_templates")
    Call<Response> deleteMessageTemplate(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Query("name") String name);

    /**
     * Retrieve templates call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @return the call
     */
    @GET("/{api-version}/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplates> retrieveTemplates(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId);

    /**
     * Retrieve templates call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param filters                   the filters
     * @return the call
     */
    @GET("/{api-version}/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplates> retrieveTemplates(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @QueryMap Map<String, Object> filters);


    /**
     * Retrieve phone number call.
     *
     * @param phoneNumberId the phone number id
     * @param queryParams   the query params
     * @return the call
     */
    @GET("/{api-version}/{phone-number-ID}")
    Call<PhoneNumber> retrievePhoneNumber(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @QueryMap Map<String, Object> queryParams);


    /**
     * Retrieve phone numbers call.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @return the call
     */
    @GET("/{api-version}/{whatsapp-business-account-ID}/phone_numbers")
    Call<PhoneNumbers> retrievePhoneNumbers(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId);

    /**
     * Request code call.
     *
     * @param phoneNumberId the phone number id
     * @param requestCode   the request code
     * @return the call
     */
    @POST("/{api-version}/{phone-number-ID}/request_code")
    Call<Response> requestCode(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @Body RequestCode requestCode);

    /**
     * Verify code call.
     *
     * @param phoneNumberId the phone number id
     * @param verifyCode    the verify code
     * @return the call
     */
    @POST("/{api-version}/{phone-number-ID}/verify_code")
    Call<Response> verifyCode(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @Body VerifyCode verifyCode);

    /**
     * Business phone number's whatsApp commerce settings call.
     *
     * @param phoneNumberId the phone number id
     * @param queryParams   the query params
     * @return the call
     */
    @GET("/{api-version}/{phone-number-ID}/whatsapp_commerce_settings")
    Call<GraphCommerceSettings> getWhatsappCommerceSettings(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @QueryMap Map<String, String> queryParams);

    /**
     * Business phone number's whatsApp commerce settings call.
     *
     * @param phoneNumberId    the phone number id
     * @param commerceDataItem the query params
     * @return the call
     */
    @POST("/{api-version}/{phone-number-ID}/whatsapp_commerce_settings")
    Call<Response> updateWhatsappCommerceSettings(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @Body CommerceDataItem commerceDataItem);
}
