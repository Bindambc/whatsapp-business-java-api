package com.whatsapp.api.impl;

import com.whatsapp.api.domain.phone.DisplayNameStatus;
import com.whatsapp.api.domain.phone.PhoneNumber;
import com.whatsapp.api.domain.phone.PhoneNumbers;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import com.whatsapp.api.service.WhatsappBusinessManagementApiService;

import java.util.List;
import java.util.Map;

import static com.whatsapp.api.WhatsappApiServiceGenerator.createService;
import static com.whatsapp.api.WhatsappApiServiceGenerator.executeSync;

/**
 * The type Whatsapp business management api.
 */
public class WhatsappBusinessManagementApi {

    private final WhatsappBusinessManagementApiService whatsappBusinessManagementApiService;

    /**
     * Instantiates a new Whatsapp business management api.
     *
     * @param token the token
     */
    public WhatsappBusinessManagementApi(String token) {
        this.whatsappBusinessManagementApiService = createService(WhatsappBusinessManagementApiService.class, token);
    }

    /**
     * Use the WhatsApp Business Management API to create new message templates,
     * media message templates, or interactive message templates.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param messageTemplate           {@link MessageTemplate} object
     * @return {@link MessageTemplateIDResponse} template id
     */
    public MessageTemplateIDResponse createMessageTemplate(String whatsappBusinessAccountId, MessageTemplate messageTemplate) {

        return executeSync(whatsappBusinessManagementApiService.createMessageTemplate(whatsappBusinessAccountId, messageTemplate));
    }

    /**
     * Update message template message template id response.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param messageTemplateId         the message template id
     * @param messageTemplate           the message template
     * @return the message template id response
     */
    public MessageTemplateIDResponse updateMessageTemplate(String whatsappBusinessAccountId, String messageTemplateId, MessageTemplate messageTemplate) {

        return executeSync(whatsappBusinessManagementApiService.updateMessageTemplate(whatsappBusinessAccountId, messageTemplateId, messageTemplate));
    }

    /**
     * Delete message template message template success response.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param name                      the name
     * @return the message template success response
     */
    public Response deleteMessageTemplate(String whatsappBusinessAccountId, String name) {

        return executeSync(whatsappBusinessManagementApiService.deleteMessageTemplate(whatsappBusinessAccountId, name));
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
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(whatsappBusinessAccountId));
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
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(whatsappBusinessAccountId, Map.of("limit", limit)));
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
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(whatsappBusinessAccountId, Map.of("name", templateName)));
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
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(whatsappBusinessAccountId, Map.of("limit", limit, "after", after)));
    }

    /**
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param phoneNumberId a phoneNumber id
     * @return PhoneNumber
     */
    public PhoneNumber retrievePhoneNumber(String whatsappBusinessAccountId, String phoneNumberId) {
        return executeSync(whatsappBusinessManagementApiService.retrievePhoneNumber(whatsappBusinessAccountId, phoneNumberId));
    }

    /**
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @return List<PhoneNumber>
     */
    public PhoneNumbers retrievePhoneNumbers(String whatsappBusinessAccountId) {
        return executeSync(whatsappBusinessManagementApiService.retrievePhoneNumbers(whatsappBusinessAccountId));
    }


    public DisplayNameStatus retrieveDisplayNameStatus(String phoneNumberId){
        return executeSync(whatsappBusinessManagementApiService.retrieveDisplayNameStatus(whatsappBusinessAccountId));

    }


}
