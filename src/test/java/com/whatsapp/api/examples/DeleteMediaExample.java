package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.TOKEN;

public class DeleteMediaExample {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        //delete media
        var response = whatsappBusinessCloudApi.deleteMedia("723050006231302");

        System.out.println(response);

    }


}
