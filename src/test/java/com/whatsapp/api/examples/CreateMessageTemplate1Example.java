package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.templates.BodyComponent;
import com.whatsapp.api.domain.templates.Category;
import com.whatsapp.api.domain.templates.Example;
import com.whatsapp.api.domain.templates.HeaderComponent;
import com.whatsapp.api.domain.templates.HeaderFormat;
import com.whatsapp.api.domain.templates.Language;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestUtils.TOKEN;
import static com.whatsapp.api.TestUtils.WABA_ID;

public class CreateMessageTemplate1Example {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        var template = new MessageTemplate();

        template.setName("welcome_template3")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(Language.EN_US)//
                .addComponent(new HeaderComponent()//
                        .setText("Wellcome title")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Hello {{1}}, welcome to our {{2}} test. ")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Mr. José", "s")//
                        ))//


        ;

        whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);
    }
}
