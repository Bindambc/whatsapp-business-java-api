package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.Component;
import com.whatsapp.api.domain.messages.Language;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.TemplateMessage;
import com.whatsapp.api.domain.messages.TextParameter;
import com.whatsapp.api.domain.templates.type.ComponentType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

public class SendTemplateTextMessageExample {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = MessageBuilder.builder()//
                .setTo(TestConstants.PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(LanguageType.PT_BR)).setName("number_confirmation")//
                                .addComponent(//
                                        new Component(ComponentType.BODY)//
                                                .addParameter(new TextParameter("18754269072")//
                                                ))


                );

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}
