package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.BodyComponent;
import com.whatsapp.api.domain.templates.Example;
import com.whatsapp.api.domain.templates.FooterComponent;
import com.whatsapp.api.domain.templates.HeaderComponent;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.WABA_ID;

public class CreateMessageTemplate8Example {

    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        var template = new MessageTemplate();

        template.setName("auth_app")//
                .setCategory(Category.AUTHENTICATION)//
                .setLanguage(LanguageType.EN_US)//
                .addComponent(new HeaderComponent()//
                        .setFormat(HeaderFormat.IMAGE).setExample(new Example().addHeaderHandleExamples("4::aW1hZ2UvanBlZw==:ARbzAaeBdkTpPbPQcqoRsHvmI1iJnyxkjZBXVACmVZBGfIOSNOqujojIUCIciq0OttnlTqKZNfbTV81PmOJ2t-eIrJ0MCQFNP5pfMJvAdd-PZQ:e:1680186259:3449824985304722:100002914375136:ARYJQLBIIVIUS1MCM1w"))
                )//
                .addComponent(new BodyComponent()//
                        .setText("Hello, scan the QR code or use the code {{1}} to authenticate on the website.")//
                        .setExample(new Example()//
                                .addBodyTextExamples("784-H45-7R4")))//
                .addComponent(new FooterComponent().setText("Do not share this message with anyone.'"));//


        System.out.println(new ObjectMapper().writeValueAsString(template));
        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        System.out.println(response);
    }
}
