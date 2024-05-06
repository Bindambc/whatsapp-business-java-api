package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.configuration.ApiVersion;
import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.messages.BodyComponent;
import com.whatsapp.api.domain.messages.ButtonComponent;
import com.whatsapp.api.domain.messages.ButtonPayloadParameter;
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
        // setting the api version
        WhatsappApiConfig.setApiVersion(ApiVersion.V17_0);
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(LanguageType.PT_BR))//
                                .setName("schedule_confirmation3")//
                                .addComponent(new BodyComponent()//
                                        .addParameter(new TextParameter("Mauricio"))//
                                        .addParameter(new TextParameter("04/11/2022"))//
                                        .addParameter(new TextParameter("14:30")))//
                                .addComponent(new ButtonComponent()//
                                        .setIndex(0)//
                                        .setSubType(ButtonSubType.QUICK_REPLY)//
                                        .addParameter(new ButtonPayloadParameter("OP_YES_48547")))//
                                .addComponent(new ButtonComponent()//
                                        .setIndex(1)//
                                        .setSubType(ButtonSubType.QUICK_REPLY)//
                                        .addParameter(new ButtonPayloadParameter("OP_NO_48548")))//
                                .addComponent(new ButtonComponent(2, ButtonSubType.QUICK_REPLY)//
                                        .addParameter(new ButtonPayloadParameter("OP_CH_48549")))//


                );

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}
