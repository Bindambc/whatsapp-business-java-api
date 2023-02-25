package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.TextMessage;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.exception.utils.Formatter;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;


public class SendMediaMessageExample {

    public static void main(String[] args) {

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
