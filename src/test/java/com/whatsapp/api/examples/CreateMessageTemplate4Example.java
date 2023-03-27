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

public class CreateMessageTemplate4Example {

    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        var template = new MessageTemplate();

        template.setName("marketing_music_878")//
                .setCategory(Category.MARKETING)//
                .setLanguage(LanguageType.EN_US)//
                .addComponent(new HeaderComponent()//
                        .setFormat(HeaderFormat.IMAGE)
                        .setExample(new Example().addHeaderHandleExamples("4::aW1hZ2UvanBlZw==:ARZdpGlLrA9uwIGGZc-UFu5viAD1BkqTCYGL8je2d7xovDZphaWG8gJPTSJfekNchsL3SWdY8-jTA9ZRq_MWro-1wfJnApfbb0ByrUoDb6nNZA:e:1679805732:3449824985304722:100002914375136:ARauotmqlFdTcNENzt0"))
                )//

                .addComponent(new BodyComponent()//
                        .setText("Join us for our live music event on {{1}}. You can get a ticket for only ${{2}}. Thanks.")//
                        .setExample(new Example()//
                                .addBodyTextExamples("May 10th, 2023", "30")//
                        ))//
                .addComponent(new ButtonComponent()//

                        .addButton(new QuickReplyButton("Shop Now")
                        )//
                        .addButton(new QuickReplyButton("Stop promotions")//
                        )


                )//
                .addComponent(new FooterComponent().setText("Not interested? Tap Stop promotions"))


        ;

        System.out.println(new ObjectMapper().writeValueAsString(template));
        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        System.out.println(response);
    }
}
