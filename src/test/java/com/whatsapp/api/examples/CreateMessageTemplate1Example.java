package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.BodyComponent;
import com.whatsapp.api.domain.templates.Example;
import com.whatsapp.api.domain.templates.HeaderComponent;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.WABA_ID;

public class CreateMessageTemplate1Example {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        var template = new MessageTemplate();

        template.setName("welcome_template3")//
                .setCategory(Category.UTILITY)//
                .setLanguage(LanguageType.EN_US)//
                .addComponent(new HeaderComponent()//
                        .setText("Wellcome title")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Hello {{1}}, welcome to our {{2}} test. ")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Mr. José", "s")//
                        ))//


        ;

        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);
        System.out.println(response);

    }
}
