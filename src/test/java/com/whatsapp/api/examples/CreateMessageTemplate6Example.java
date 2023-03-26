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

public class CreateMessageTemplate6Example {

    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        var template = new MessageTemplate();

        template.setName("marketing_coffee")//
                .setCategory(Category.MARKETING)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setFormat(HeaderFormat.IMAGE)
                        .setExample(new Example().addHeaderHandleExamples("4::aW1hZ2UvanBlZw==:ARZdpGlLrA9uwIGGZc-UFu5viAD1BkqTCYGL8je2d7xovDZphaWG8gJPTSJfekNchsL3SWdY8-jTA9ZRq_MWro-1wfJnApfbb0ByrUoDb6nNZA:e:1679805732:3449824985304722:100002914375136:ARauotmqlFdTcNENzt0"))
                )//

                .addComponent(new BodyComponent()//
                        .setText("Venha aproveitar nossos cafés especiais em nossa super promoção. Nossos expressos são a partir de R${{1}}")//
                        .setExample(new Example()//
                                .addBodyTextExamples("15")//
                        ))//
                .addComponent(new ButtonComponent()//

                        .addButton(new QuickReplyButton("Saiba mais")
                        )//
                        .addButton(new QuickReplyButton("Parar promoções")//
                        )


                )//
                .addComponent(new FooterComponent().setText("Sem interesse? Clique em parar promoções"))


        ;

        System.out.println(new ObjectMapper().writeValueAsString(template));
        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        System.out.println(response);
    }
}
