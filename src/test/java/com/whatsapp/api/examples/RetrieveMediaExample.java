package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import java.io.IOException;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;

public class RetrieveMediaExample {

    public static void main(String[] args) throws IOException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();





        var response = whatsappBusinessCloudApi.retrieveMediaUrl( "1227829768162607");

//1227829768162607
        System.out.println(response);
    }


}
