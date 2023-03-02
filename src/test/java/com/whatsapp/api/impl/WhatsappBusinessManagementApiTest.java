package com.whatsapp.api.impl;

import com.whatsapp.api.MockServerUtilsTest;
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
import com.whatsapp.api.exception.utils.Formatter;
import mockwebserver3.MockResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.WABA_ID;

class WhatsappBusinessManagementApiTest extends MockServerUtilsTest {


    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));


        var template = new MessageTemplate();

        template.setName("welcome_template2")//
                .setCategory(com.whatsapp.api.domain.templates.type.Category.TRANSACTIONAL)//
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

        Assertions.assertEquals("952305634123456", response.id());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#updateMessageTemplate(String, String, MessageTemplate)}
     */
    @Test
    void testUpdateMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));

        var template = new MessageTemplate();

        template.setName("welcome_template")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(LanguageType.EN_US)//
                .addComponent(new HeaderComponent()//
                        .setText("Wellcome title")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Hello {{1}}, welcome to our {{2}} test. ")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Mr. José", "satisfaction")//
                        ))//


        ;

        var response = whatsappBusinessCloudApi.updateMessageTemplate(WABA_ID, "952305634123456", template);

        Assertions.assertEquals("952305634123456", response.id());
    }


    /**
     * Method under test: {@link WhatsappBusinessManagementApi#deleteMessageTemplate(String, String)}
     */
    @Test
    void testDeleteMessageTemplate() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/deleteTemplate.json")));

        var resp = whatsappBusinessCloudApi.deleteMessageTemplate(WABA_ID, "welcome_template");

        Assertions.assertTrue(resp.success());

    }


    @Test
    void testCreateMessageTemplate2() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));

        var template = new MessageTemplate();

        template.setName("number_confirmation")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setText("Código de confirmação")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Este é o seu código de confirmação: " + Formatter.bold("{{1}}."))//
                        .setExample(new Example()//
                                .addBodyTextExamples("1458425")//
                        ))//
                .addComponent(new FooterComponent().setText("Use este código para confirmar seu telefone."))


        ;

        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        Assertions.assertEquals("952305634123456", response.id());
    }


    @Test
    void testCreateMessageTemplate3() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));

        var template = new MessageTemplate();

        template.setName("schedule_confirmation3")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setText("Confirmação de Atendimento")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Olá " + Formatter.bold("{{1}}") + ", passando aqui para confirmar seu horário no dia " + Formatter.bold("{{2}}") + " as " + Formatter.bold("{{3}}h") + ".\nVocê confirma que comparecerá?")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Maria", "04/11/2022", "13:30")//
                        ))//
                .addComponent(new ButtonComponent()//
                        .addButton(new QuickReplyButton("SIM"))//
                        .addButton(new QuickReplyButton("NÃO"))//
                        .addButton(new QuickReplyButton("REMARCAR")//
                        )


                )//
                .addComponent(new FooterComponent().setText("Utilize um dos botões abaixo para a confirmação"))


        ;

        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        Assertions.assertEquals("952305634123456", response.id());
    }

    @Test
    void testCreateMessageTemplate4() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/template.json")));

        var template = new MessageTemplate();

        template.setName("schedule_confirmation5")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setText("Confirmação de Atendimento")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Olá " + Formatter.bold("{{1}}") + ", passando aqui para confirmar seu horário no dia " + Formatter.bold("{{2}}") + " as " + Formatter.bold("{{3}}h") + ".\nVocê confirma que comparecerá?")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Maria", "04/11/2022", "13:30")//
                        ))//
                .addComponent(new ButtonComponent()//
                        .addButton(new QuickReplyButton("SIM"))//
                        .addButton(new QuickReplyButton("NÃO"))//


                )//
                .addComponent(new FooterComponent().setText("Utilize um dos botões abaixo para a confirmação"))


        ;

        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        Assertions.assertEquals("952305634123456", response.id());
    }


    @Test
    void testRetrieveMessageTemplate1() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/retTemplate1.json")));

        var templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID);


        Assertions.assertEquals(7, templates.data().size());
        Assertions.assertEquals("welcome_template3", templates.data().get(0).name());
        Assertions.assertEquals("Hello {{1}}, welcome to our {{2}} test.", templates.data().get(0).components().get(1).getText());
        Assertions.assertEquals("1772832833109192", templates.data().get(6).id());

    }

    @Test
    void testRetrieveMessageTemplate2() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/retTemplate2.json")));

        var templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID, 2);


        Assertions.assertEquals(2, templates.data().size());
        Assertions.assertEquals("welcome_template3", templates.data().get(0).name());
        Assertions.assertEquals("Hello {{1}}, welcome to our {{2}} test.", templates.data().get(0).components().get(1).getText());
        Assertions.assertEquals("https://graph.facebook.com/v15.0/0000000000/message_templates?limit=2&after=MQZDZD", templates.paging().next());

    }

    @Test
    void testRetrieveMessageTemplate3() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/retTemplate3.json")));

        var templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID, "welcome_template3");


        Assertions.assertEquals(1, templates.data().size());
        Assertions.assertEquals("welcome_template3", templates.data().get(0).name());
        Assertions.assertEquals("Hello {{1}}, welcome to our {{2}} test.", templates.data().get(0).components().get(1).getText());

    }
}

