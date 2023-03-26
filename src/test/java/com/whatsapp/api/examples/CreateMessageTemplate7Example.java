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
import com.whatsapp.api.domain.templates.PhoneNumberButton;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.WABA_ID;

public class CreateMessageTemplate7Example {

    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        var template = new MessageTemplate();

        template.setName("call_to_me")//
                .setCategory(Category.UTILITY)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setText("Problemas com a entrega do seu pedido")//
                        .setFormat(HeaderFormat.TEXT))//

                .addComponent(new BodyComponent()//
                        .setText("Olá {{1}}, Tivemos um problema com a entrega do seu pedido {{2}}. Por favor, entre em contato com a central de atendimento para obter mais detalhes")//

                        .setExample(new Example()//
                                .addBodyTextExamples("Maria","FE-15454T45001")))//
                .addComponent(new ButtonComponent()//

                        .addButton(new PhoneNumberButton("Ligar agora", "16503087300"))//


                )//
                .addComponent(new FooterComponent().setText("Clique no botão abaixo para ligar agora."))


        ;

        System.out.println(new ObjectMapper().writeValueAsString(template));
        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        System.out.println(response);
    }
}
