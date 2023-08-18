package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.config.CommerceDataItem;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;

public class UpdateWhatsappCommerceSettingsExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi();

        CommerceDataItem dataItem = new CommerceDataItem()
                .setCatalogVisible(true);

        var response = whatsappBusinessManagementApi.updateWhatsappCommerceSettings(PHONE_NUMBER_ID, dataItem);

        System.out.println(response);

    }
}