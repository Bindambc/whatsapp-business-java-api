package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestUtils.TOKEN;
import static com.whatsapp.api.TestUtils.WABA_ID;

public class DeleteMessageTemplate {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();


        whatsappBusinessCloudApi.deleteMessageTemplate(WABA_ID, "welcome_template");
    }
}
