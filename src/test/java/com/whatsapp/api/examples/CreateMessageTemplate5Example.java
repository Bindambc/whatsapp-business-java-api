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
import com.whatsapp.api.domain.templates.UrlButton;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import java.util.Collections;

import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.WABA_ID;

public class CreateMessageTemplate5Example {

    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        var template = new MessageTemplate();

        template.setName("new_classes_pdf_v2")//
                .setCategory(Category.UTILITY)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setFormat(HeaderFormat.DOCUMENT)
                        .setExample(new Example().addHeaderHandleExamples("4::aW1hZ2UvanBlZw==:ARb0a9E9s7-LdErXAXQCwyh7Oy-_h9gBo4ljPOyyhHynnXo53CK0YUjCCREvS4fB-0CwfSQbNnJve1C9fJC3ikLOfQO-9aeWYdMmkMUJgGJI0g:e:1680011044:3449824985304722:100002914375136:ARZMcC4QfmCW8V85Lco"))
                )//

                .addComponent(new BodyComponent()//
                        .setText("Olá {{1}}, seu professou publicou novas aulas na plataforma de ensino.")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Maria")//
                        ))//
                .addComponent(new ButtonComponent()//

                        .addButton(new UrlButton("Assistir agora")//
                                .setUrl("https://www.coursera.org/{{1}}")//
                                .setUrlExample(Collections.singletonList("https://www.coursera.org/?authMode=login"))//
                        )//



                )//
                .addComponent(new FooterComponent().setText("Click on the button below to watch now"))


        ;

        System.out.println(new ObjectMapper().writeValueAsString(template));
        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        System.out.println(response);
    }
}
