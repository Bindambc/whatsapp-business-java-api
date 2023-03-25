package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.BodyComponent;
import com.whatsapp.api.domain.messages.ButtonComponent;
import com.whatsapp.api.domain.messages.ButtonTextParameter;
import com.whatsapp.api.domain.messages.Document;
import com.whatsapp.api.domain.messages.DocumentParameter;
import com.whatsapp.api.domain.messages.HeaderComponent;
import com.whatsapp.api.domain.messages.Language;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.TemplateMessage;
import com.whatsapp.api.domain.messages.TextParameter;
import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

public class SendTemplateUtilityDocumentMessageExample {
    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(LanguageType.EN_US))//
                                .setName("new_classes_pdf")//
                                .addComponent(new HeaderComponent()//
                                        .addParameter(new DocumentParameter()//
                                                .setDocument(new Document()//
                                                        .setFileName("Class.pdf").setId("928860901494862")//
                                                ))//
                                ).addComponent(//
                                        new BodyComponent()//
                                                .addParameter(new TextParameter("Mauricio Binda")))//
                                .addComponent(new ButtonComponent()//
                                        .setIndex(0)//
                                        .setSubType(ButtonSubType.URL)//
                                        .addParameter(new ButtonTextParameter("career-academy/?trk_ref=globalnav")))//

                );
        System.out.println(new ObjectMapper().writeValueAsString(message));

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}
