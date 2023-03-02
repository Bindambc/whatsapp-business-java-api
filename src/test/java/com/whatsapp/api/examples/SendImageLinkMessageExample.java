package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.ImageMessage;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;


public class SendImageLinkMessageExample {

    public static void main(String[] args) {


        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var imageMessage = new ImageMessage()//
                .setLink("https://upload.wikimedia.org/wikipedia/pt/4/45/Yoda.jpg").setCaption("See this image, please");

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildImageMessage(imageMessage);


        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);

    }
}
