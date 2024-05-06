package com.whatsapp.api.impl;

import com.whatsapp.api.configuration.ApiVersion;
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
import com.whatsapp.api.service.WhatsappBusinessManagementApiService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.whatsapp.api.WhatsappApiServiceGenerator.createService;
import static com.whatsapp.api.WhatsappApiServiceGenerator.executeSync;
import static com.whatsapp.api.configuration.WhatsappApiConfig.getApiVersion;

/**
 * The type Whatsapp business management api.
 */
public class WhatsappBusinessManagementApi {

    private final ApiVersion apiVersion;

    private final WhatsappBusinessManagementApiService whatsappBusinessManagementApiService;

    /**
     * Instantiates a new Whatsapp business management api.
     *
     * @param token the token
     */
    public WhatsappBusinessManagementApi(String token) {
        this.apiVersion = getApiVersion();
        this.whatsappBusinessManagementApiService = createService(WhatsappBusinessManagementApiService.class, token);
    }

    /**
     * Instantiates a new Whatsapp business management api, specifying api version
     *
     * @param token      the token
     * @param apiVersion api version
     */
    public WhatsappBusinessManagementApi(String token, ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
        this.whatsappBusinessManagementApiService = createService(WhatsappBusinessManagementApiService.class, token);
    }

    /**
     * Use the WhatsApp Business Management API to create new message templates,
     * media message templates, or interactive message templates.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param messageTemplate           {@link MessageTemplate} object
     * @return {@link Template} template
     */
    public Template createMessageTemplate(String whatsappBusinessAccountId, MessageTemplate messageTemplate) {

        return executeSync(whatsappBusinessManagementApiService.createMessageTemplate(apiVersion.getValue(), whatsappBusinessAccountId, messageTemplate));
    }

    /**
     * Update message template message template id response.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param messageTemplateId         the message template id
     * @param messageTemplate           the message template
     * @return the message template id response
     */
    public Template updateMessageTemplate(String whatsappBusinessAccountId, String messageTemplateId, MessageTemplate messageTemplate) {

        return executeSync(whatsappBusinessManagementApiService.updateMessageTemplate(apiVersion.getValue(), whatsappBusinessAccountId, messageTemplateId, messageTemplate));
    }

    /**
     * Delete message template message template success response.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param name                      the name
     * @return the message template success response
     */
    public Response deleteMessageTemplate(String whatsappBusinessAccountId, String name) {

        return executeSync(whatsappBusinessManagementApiService.deleteMessageTemplate(apiVersion.getValue(), whatsappBusinessAccountId, name));
    }

    /**
     * When a message template is returned, the response will include all its translations (if any).
     * Message templates are grouped by the name field. You can use the limit parameter to define the number of items
     * returned. This limit applies to the maximum number of message template names that may be returned,
     * not the maximum number of objects.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @return {@link MessageTemplates} List of templates
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates">Message templates</a>
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(apiVersion.getValue(), whatsappBusinessAccountId));
    }

    /**
     * Retrieve templates message templates.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param limit                     You can use the limit parameter to define the number of items returned. This limit applies to the maximum number of message template names that may be returned,                                  not the maximum number of objects
     * @return {@link MessageTemplates} List of templates
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates">Message templates</a>
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId, int limit) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(apiVersion.getValue(), whatsappBusinessAccountId, Map.of("limit", limit)));
    }

    /**
     * Retrieve templates message templates.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param templateName              template name.
     * @return {@link MessageTemplates} List of templates
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates">Message templates</a>
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId, String templateName) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(apiVersion.getValue(), whatsappBusinessAccountId, Map.of("name", templateName)));
    }

    /**
     * Retrieve templates message templates.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param limit                     You can use the limit parameter to define the number of items returned. This limit applies to the maximum number of message template names that may be returned,                                  not the maximum number of objects
     * @param after                     next
     * @return message templates
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId, int limit, String after) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(apiVersion.getValue(), whatsappBusinessAccountId, Map.of("limit", limit, "after", after)));
    }

    /**
     * Retrieve a phone number by ID
     *
     * @param phoneNumberId the phone number id
     * @return the phone number
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account/phone_numbers/">api docs</a>
     */
    public PhoneNumber retrievePhoneNumber(String phoneNumberId) {

        return executeSync(whatsappBusinessManagementApiService.retrievePhoneNumber(apiVersion.getValue(), phoneNumberId, new HashMap<>()));
    }


    /**
     * Retrieve phone number.
     * <p>
     * Include fields=name_status as a query string parameter to get the status of a display name associated with a specific phone number.
     * This field is currently in beta and not available to all developers.
     * </p>
     *
     * @param phoneNumberId the phone number id
     * @param fields        the fields. Available options:                      <ul>                      <li>verified_name</li>                      <li>code_verification_status</li>                      <li>display_phone_number</li>                      <li>quality_rating</li>                      <li>name_status</li>                      </ul>
     * @return the phone number
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account/phone_numbers/">api docs</a>
     */
    public PhoneNumber retrievePhoneNumber(String phoneNumberId, String... fields) {
        Objects.requireNonNull(fields, "fields cannot be null");
        return executeSync(whatsappBusinessManagementApiService.retrievePhoneNumber(apiVersion.getValue(), phoneNumberId, Map.of("fields", String.join(",", fields))));
    }


    /**
     * Retrieve phone numbers from a Whatsapp Business Account
     * When you query all the phone numbers for a WhatsApp Business Account, each phone number has an id. You can directly query for a phone number using this id.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @return the phone numbers
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account/phone_numbers/">api docs</a>
     */
    public PhoneNumbers retrievePhoneNumbers(String whatsappBusinessAccountId) {
        return executeSync(whatsappBusinessManagementApiService.retrievePhoneNumbers(apiVersion.getValue(), whatsappBusinessAccountId));
    }


    /**
     * You need to verify the phone number you want to use to send messages to your customers. Phone numbers must be verified through SMS/voice call. The verification process can be done through this method.
     *
     * @param phoneNumberId the phone number id
     * @param requestCode   the request code
     * @return the response
     */
    public Response requestCode(String phoneNumberId, RequestCode requestCode) {
        return executeSync(whatsappBusinessManagementApiService.requestCode(apiVersion.getValue(), phoneNumberId, requestCode));
    }

    /**
     * After you received a SMS or Voice request code from Request Verification Code, you need to verify the code that was sent to you.
     * To verify this code, use this method
     *
     * @param phoneNumberId the phone number id
     * @param verifyCode    the verify code
     * @return the response
     */
    public Response verifyCode(String phoneNumberId, VerifyCode verifyCode) {
        return executeSync(whatsappBusinessManagementApiService.verifyCode(apiVersion.getValue(), phoneNumberId, verifyCode));
    }


    /**
     * Get a business phone number's WhatsApp Commerce Settings. Returns empty if commerce settings have not been set.
     *
     * @param phoneNumberId the phone number id
     * @param fields        the fields. Available options:
     *                      <ul>
     *                          <li>id</li>
     *                          <li>is_cart_enabled</li>
     *                          <li>is_catalog_visible</li>
     *                      </ul>
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account-to-number-current-status/whatsapp_commerce_settings">api docs</a>
     */
    public GraphCommerceSettings getWhatsappCommerceSettings(String phoneNumberId, String... fields) {
        return executeSync(whatsappBusinessManagementApiService.getWhatsappCommerceSettings(apiVersion.getValue(), phoneNumberId, Map.of("fields", String.join(",", fields))));
    }

    /**
     * Update a business WhatsApp Commerce Settings.
     *
     * @param phoneNumberId    the phone number id
     * @param commerceDataItem the commerce configuration fields
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account-to-number-current-status/whatsapp_commerce_settings">api docs</a>
     */
    public Response updateWhatsappCommerceSettings(String phoneNumberId, CommerceDataItem commerceDataItem) {
        return executeSync(whatsappBusinessManagementApiService.updateWhatsappCommerceSettings(apiVersion.getValue(), phoneNumberId, commerceDataItem));
    }

}
