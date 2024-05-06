package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.configuration.ApiVersion;
import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.messages.LocationMessage;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;

public class SendLocationMessageExample {

    public static void main(String[] args) {

        WhatsappApiConfig.setApiVersion(ApiVersion.V17_0);
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);


        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var locationMessage = new LocationMessage()//
                .setLongitude("38.819830")
                .setLatitude("-77.151700");

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildLocationMessage(locationMessage);

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);

    }

}
