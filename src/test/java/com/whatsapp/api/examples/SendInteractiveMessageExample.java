package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.Action;
import com.whatsapp.api.domain.messages.Body;
import com.whatsapp.api.domain.messages.Button;
import com.whatsapp.api.domain.messages.InteractiveMessage;
import com.whatsapp.api.domain.messages.InteractiveMessageType;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.Reply;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;


public class SendInteractiveMessageExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .addButton(new Button() //
                                        .setType("reply")
                                        .setReply(new Reply() //
                                                .setId("UNIQUE_BUTTON_ID_1") //
                                                .setTitle("BUTTON_TITLE_1"))) //
                                .addButton(new Button() //
                                        .setType("reply")
                                        .setReply(new Reply() //
                                                .setId("UNIQUE_BUTTON_ID_2") //
                                                .setTitle("BUTTON_TITLE_2")))
                        ) //
                        .setType(InteractiveMessageType.BUTTON) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);

    }
}
