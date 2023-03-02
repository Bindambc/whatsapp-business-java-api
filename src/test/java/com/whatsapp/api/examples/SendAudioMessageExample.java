package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.AudioMessage;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;


public class SendAudioMessageExample {

    public static void main(String[] args) {


        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var audioMessage = new AudioMessage()//
                .setId("6418001414900549");

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildAudioMessage(audioMessage);


        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);

    }
}
