package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.configuration.ApiVersion;
import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.TextMessage;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;
import com.whatsapp.api.utils.Formatter;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;


public class SendTextMessageExample {

    public static void main(String[] args) {

        WhatsappApiConfig.setApiVersion(ApiVersion.V18_0);
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTextMessage(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false));


        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);

    }
}
