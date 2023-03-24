package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.BodyComponent;
import com.whatsapp.api.domain.templates.ButtonComponent;
import com.whatsapp.api.domain.templates.Example;
import com.whatsapp.api.domain.templates.FooterComponent;
import com.whatsapp.api.domain.templates.HeaderComponent;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.QuickReplyButton;
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

        template.setName("auth_code_2")//
                .setCategory(Category.AUTHENTICATION)//
                .setLanguage(LanguageType.EN_US)//
                .addComponent(new HeaderComponent()//
                        .setFormat(HeaderFormat.TEXT).setText("Your authentication code for {{1}}")//
                        .setExample(new Example().addHeaderTextExamples("App X")))//
                .addComponent(new BodyComponent()//
                        .setText("Please use the code {{1}} to sign in to your account. Do not provide this code to third parties.")//
                        .setExample(new Example()//
                                .addBodyTextExamples("784-H45-7R4")))//
                .addComponent(new FooterComponent().setText("Did you not request the code? Click on 'Not me'"))//
                .addComponent(new ButtonComponent()//
                        .addButton(new QuickReplyButton("Not me"))//


                )//


        ;

        System.out.println(new ObjectMapper().writeValueAsString(template));
        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        System.out.println(response);
    }
}
