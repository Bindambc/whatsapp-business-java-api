package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.BodyComponent;
import com.whatsapp.api.domain.messages.HeaderComponent;
import com.whatsapp.api.domain.messages.Image;
import com.whatsapp.api.domain.messages.ImageParameter;
import com.whatsapp.api.domain.messages.Language;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.TemplateMessage;
import com.whatsapp.api.domain.messages.TextParameter;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

public class SendTemplateAuthMessageExample {
    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(LanguageType.PT_BR))//
                                .setName("auth_app")//
                                .addComponent(new HeaderComponent()//
                                        .addParameter(new ImageParameter()//
                                                .setImage(new Image("554066036582230", null))
                                        )

                                ).addComponent(//
                                        new BodyComponent()//
                                                .addParameter(new TextParameter("T87-G74-876")))//

                );
        System.out.println(new ObjectMapper().writeValueAsString(message));

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}
