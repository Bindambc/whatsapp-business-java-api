package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.BodyComponent;
import com.whatsapp.api.domain.messages.ButtonComponent;
import com.whatsapp.api.domain.messages.ButtonTextParameter;
import com.whatsapp.api.domain.messages.Language;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.TemplateMessage;
import com.whatsapp.api.domain.messages.TextParameter;
import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

public class SendTemplateButtonMessageExample {
    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(LanguageType.PT_BR))//
                                .setName("schedule_confirmation3")//
                                .addComponent(new BodyComponent().addParameter(new TextParameter("Mauricio"))//
                                        .addParameter(new TextParameter("04/11/2022"))//
                                        .addParameter(new TextParameter("14:30")))//
                                .addComponent(new ButtonComponent().setIndex(0).setSubType(ButtonSubType.QUICK_REPLY).addParameter(new ButtonTextParameter("O747"))

                                ).addComponent(new ButtonComponent().setIndex(1).setSubType(ButtonSubType.QUICK_REPLY).addParameter(new ButtonTextParameter("475"))

                                ).addComponent(new ButtonComponent().setIndex(2).setSubType(ButtonSubType.QUICK_REPLY).addParameter(new ButtonTextParameter("8754"))

                                )


                );

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}
