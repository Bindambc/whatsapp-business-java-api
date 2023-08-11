package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;

public class GetWhatsappCommerceSettingsExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi();
        //request without parameters
        var response = whatsappBusinessManagementApi.getWhatsappCommerceSettings(PHONE_NUMBER_ID);

        System.out.println(response);

        //request with parameters
        var response2 = whatsappBusinessManagementApi.getWhatsappCommerceSettings(PHONE_NUMBER_ID, "id", "is_cart_enabled");

        System.out.println(response2);

    }
}