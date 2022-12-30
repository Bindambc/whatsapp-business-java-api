package com.whatsapp.api.impl;

import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MessageTemplateIDResponse;
import com.whatsapp.api.domain.templates.response.MessageTemplateSuccessResponse;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import com.whatsapp.api.service.WhatsappBusinessManagementApiService;

import java.util.Map;

import static com.whatsapp.api.WhatsappApiServiceGenerator.createService;
import static com.whatsapp.api.WhatsappApiServiceGenerator.executeSync;

public class WhatsappBusinessManagementApi {

    private final WhatsappBusinessManagementApiService whatsappBusinessManagementApiService;

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

    public MessageTemplateIDResponse updateMessageTemplate(String whatsappBusinessAccountId, String messageTemplateId, MessageTemplate messageTemplate) {

        return executeSync(whatsappBusinessManagementApiService.updateMessageTemplate(whatsappBusinessAccountId, messageTemplateId, messageTemplate));
    }

    public MessageTemplateSuccessResponse deleteMessageTemplate(String whatsappBusinessAccountId, String name) {

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
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param limit                     You can use the limit parameter to define the number of items returned. This limit applies to the maximum number of message template names that may be returned,
     *                                  not the maximum number of objects
     * @return {@link MessageTemplates} List of templates
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates">Message templates</a>
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId, int limit) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(whatsappBusinessAccountId, Map.of("limit", limit)));
    }

    /**
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param templateName              template name.
     * @return {@link MessageTemplates} List of templates
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates">Message templates</a>
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId, String templateName) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(whatsappBusinessAccountId, Map.of("name", templateName)));
    }

    /**
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param limit                     You can use the limit parameter to define the number of items returned. This limit applies to the maximum number of message template names that may be returned,
     *                                  not the maximum number of objects
     * @param after                     next
     * @return
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId, int limit, String after) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(whatsappBusinessAccountId, Map.of("limit", limit, "after", after)));
    }


}
