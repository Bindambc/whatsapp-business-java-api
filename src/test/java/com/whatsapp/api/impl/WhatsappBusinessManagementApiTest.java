package com.whatsapp.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.MockServerUtilsTest;
import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.config.CommerceDataItem;
import com.whatsapp.api.domain.phone.RequestCode;
import com.whatsapp.api.domain.phone.VerifyCode;
import com.whatsapp.api.domain.phone.type.CodeMethodType;
import com.whatsapp.api.domain.phone.type.NameStatusType;
import com.whatsapp.api.domain.phone.type.QualityRatingType;
import com.whatsapp.api.domain.templates.BodyComponent;
import com.whatsapp.api.domain.templates.ButtonComponent;
import com.whatsapp.api.domain.templates.Example;
import com.whatsapp.api.domain.templates.FooterComponent;
import com.whatsapp.api.domain.templates.HeaderComponent;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.PhoneNumberButton;
import com.whatsapp.api.domain.templates.QuickReplyButton;
import com.whatsapp.api.domain.templates.UrlButton;
import com.whatsapp.api.domain.templates.type.ButtonType;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.HeaderFormat;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.exception.WhatsappApiException;
import com.whatsapp.api.utils.Formatter;
import mockwebserver3.MockResponse;
import mockwebserver3.RecordedRequest;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;

import static com.whatsapp.api.configuration.WhatsappApiConfig.API_VERSION;

class WhatsappBusinessManagementApiTest extends MockServerUtilsTest {

    public final String DEFAULT_TEMPLATE_RESPONSE = """
            {
              "status": "REJECTED",
              "category": "UTILITY",
              "id": "952305634123456"
            }
            """;
    private final String PHONE_NUMBER_ID = "411001010101010";
    private final String TOKEN = "54f6sd5f4654df21sdfs56d4fsd5f41f8we546F54f5dfF4FRDFGfGSHe54rf6sd5f4g55";
    private final String WABA_ID = "57856727575875757";

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplate() throws InterruptedException, JSONException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_TEMPLATE_RESPONSE));

        var expectedJson = """
                {
                   "name": "welcome_template2",
                   "category": "UTILITY",
                   "components": [
                      {
                         "format": "TEXT",
                         "type": "HEADER",
                         "text": "Wellcome title"
                      },
                      {
                         "type": "BODY",
                         "text": "Hello {{1}}, welcome to our {{2}} test. ",
                         "example": {
                            "body_text": [
                               [
                                  "Mr. José",
                                  "s"
                               ]
                            ]
                         }
                      }
                   ],
                   "language": "en_US"
                }
                """;

        var template = new MessageTemplate();

        template.setName("welcome_template2")//
                .setCategory(Category.UTILITY)//
                .setLanguage(LanguageType.EN_US)//
                .addComponent(new HeaderComponent()//
                        .setText("Wellcome title")//
                        .setFormat(HeaderFormat.TEXT))//
                .addComponent(new BodyComponent()//
                        .setText("Hello {{1}}, welcome to our {{2}} test. ")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Mr. José", "s")//
                        ));

        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        var request = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", request.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/message_templates", request.getPath());

        JSONAssert.assertEquals(expectedJson, request.getBody().readUtf8(), JSONCompareMode.STRICT);

        Assertions.assertEquals("952305634123456", response.id());
        Assertions.assertEquals("REJECTED", response.status());
        Assertions.assertEquals(Category.UTILITY, response.category());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplate2() throws IOException, URISyntaxException, InterruptedException, JSONException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_TEMPLATE_RESPONSE));

        var expectedJson = fromResource("/expected/template/expectedTemplate1.json");

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
                .addComponent(new FooterComponent().setText("Use este código para confirmar seu telefone."));

        whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        var request = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", request.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/message_templates", request.getPath());

        JSONAssert.assertEquals(expectedJson, request.getBody().readUtf8(), JSONCompareMode.STRICT);

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplate3() throws IOException, URISyntaxException, InterruptedException, JSONException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_TEMPLATE_RESPONSE));

        var expectedJson = fromResource("/expected/template/expectedTemplate2.json");

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
                        ))//
                .addComponent(new FooterComponent().setText("Utilize um dos botões abaixo para a confirmação"));

        var response = whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);
        Assertions.assertNotNull(response);

        var request = mockWebServer.takeRequest();

        Assertions.assertEquals("POST", request.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/message_templates", request.getPath());

        JSONAssert.assertEquals(expectedJson, request.getBody().readUtf8(), JSONCompareMode.STRICT);
    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplate4() throws IOException, URISyntaxException, InterruptedException, JSONException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_TEMPLATE_RESPONSE));
        var expectedJson = fromResource("/expected/template/expectedTemplate4.json");
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
                .addComponent(new FooterComponent().setText("Utilize um dos botões abaixo para a confirmação"))//
                .addComponent(new ButtonComponent()//
                        .addButton(new QuickReplyButton("SIM"))//
                        .addButton(new QuickReplyButton("NÃO"))//
                );

        whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        var request = mockWebServer.takeRequest();

        Assertions.assertEquals("POST", request.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/message_templates", request.getPath());

        JSONAssert.assertEquals(expectedJson, request.getBody().readUtf8(), JSONCompareMode.STRICT);
    }


    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplateUtility1() throws IOException, URISyntaxException, InterruptedException, JSONException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_TEMPLATE_RESPONSE));
        var expectedJson = fromResource("/expected/template/expectedTemplate6.json");
        var template = new MessageTemplate();

        template.setName("new_classes_pdf_v2")//
                .setCategory(Category.UTILITY)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setFormat(HeaderFormat.DOCUMENT).setExample(new Example().addHeaderHandleExamples("4::aW1hZ2UvanBlZw==:ARb0a9E9s7-LdErXAXQCwyh7Oy-_h9gBo4ljPynnXo53CKOyyhHYUjCCREvS4fB-0CwfSQbNn9fJC3ikLOJve1CfQO-9aeWYdMmkMUJgGJI0g:e:1680011044:3449853982404722:100007529143136:ARZMcC4QfmCW8V85Lco")))//
                .addComponent(new BodyComponent()//
                        .setText("Olá {{1}}, seu professou publicou novas aulas na plataforma de ensino.")//
                        .setExample(new Example()//
                                .addBodyTextExamples("Maria")//
                        ))//
                .addComponent(new FooterComponent().setText("Click on the button below to watch now"))//
                .addComponent(new ButtonComponent()//
                        .addButton(new UrlButton("Assistir agora")//
                                .setUrl("https://www.coursera.org/{{1}}")//
                                .setUrlExample(Collections.singletonList("https://www.coursera.org/?authMode=login"))//
                        ));

        whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        var request = mockWebServer.takeRequest();

        Assertions.assertEquals("POST", request.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/message_templates", request.getPath());

        JSONAssert.assertEquals(expectedJson, request.getBody().readUtf8(), JSONCompareMode.STRICT);
    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplateUtility2() throws IOException, URISyntaxException, InterruptedException, JSONException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_TEMPLATE_RESPONSE));
        var expectedJson = fromResource("/expected/template/expectedTemplate8.json");
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
                                .addBodyTextExamples("Maria", "FE-15454T45001")))//
                .addComponent(new ButtonComponent()//
                        .addButton(new PhoneNumberButton("Ligar agora", "16503087300"))//
                )//
                .addComponent(new FooterComponent().setText("Clique no botão abaixo para ligar agora."));

        whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        var request = mockWebServer.takeRequest();

        Assertions.assertEquals("POST", request.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/message_templates", request.getPath());

        JSONAssert.assertEquals(expectedJson, request.getBody().readUtf8(), JSONCompareMode.STRICT);
    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplateAuthentication() throws IOException, URISyntaxException, InterruptedException, JSONException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_TEMPLATE_RESPONSE));
        var expectedJson = fromResource("/expected/template/expectedTemplate9.json");
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
                );

        whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        var request = mockWebServer.takeRequest();

        Assertions.assertEquals("POST", request.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/message_templates", request.getPath());

        JSONAssert.assertEquals(expectedJson, request.getBody().readUtf8(), JSONCompareMode.STRICT);
    }


    /**
     * Method under test: {@link WhatsappBusinessManagementApi#createMessageTemplate(String, MessageTemplate)}
     */
    @Test
    void testCreateMessageTemplateMarketing2() throws IOException, URISyntaxException, InterruptedException, JSONException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(DEFAULT_TEMPLATE_RESPONSE));
        var expectedJson = fromResource("/expected/template/expectedTemplate7.json");
        var template = new MessageTemplate();

        template.setName("marketing_coffee")//
                .setCategory(Category.MARKETING)//
                .setLanguage(LanguageType.PT_BR)//
                .addComponent(new HeaderComponent()//
                        .setFormat(HeaderFormat.IMAGE).setExample(new Example().addHeaderHandleExamples("4::aW1hZ2UvanBlZw==:ARZdpGlLrA9uwIGGZc-UFu5viAD1BkqTCYGL8je2d7xovDZphaWG8gJPTSJfekNchsL3SWdY8-jTA9ZRq_MWro-1wfJnApfbb0ByrUoDb6nNZA:e:1679805732:3449824985304722:100002914375136:ARauotmqlFdTcNENzt0")))//

                .addComponent(new BodyComponent()//
                        .setText("Venha aproveitar nossos cafés especiais em nossa super promoção. Nossos expressos são a partir de R${{1}}")//
                        .setExample(new Example()//
                                .addBodyTextExamples("15")//
                        ))//
                .addComponent(new ButtonComponent()//

                        .addButton(new QuickReplyButton("Saiba mais"))//
                        .addButton(new QuickReplyButton("Parar promoções")//
                        ))//
                .addComponent(new FooterComponent().setText("Sem interesse? Clique em parar promoções"));


        whatsappBusinessCloudApi.createMessageTemplate(WABA_ID, template);

        var request = mockWebServer.takeRequest();

        Assertions.assertEquals("POST", request.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/message_templates", request.getPath());

        JSONAssert.assertEquals(expectedJson, request.getBody().readUtf8(), JSONCompareMode.STRICT);
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
                        ));

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
    void testRetrieveMessageTemplate1() throws IOException, URISyntaxException, JSONException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        var expectedJson = fromResource("/retTemplate1.json");

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(expectedJson));

        var templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID);
        //TODO: review button
        var returnedJson = new ObjectMapper().writeValueAsString(templates);

        JSONAssert.assertEquals(expectedJson, returnedJson, JSONCompareMode.STRICT);
        // data[1].components[3].buttons[0]

        Assertions.assertEquals(7, templates.data().size());
        Assertions.assertEquals("welcome_template3", templates.data().get(0).name());
        Assertions.assertEquals("Hello {{1}}, welcome to our {{2}} test.", templates.data().get(0).components().get(1).getText());
        Assertions.assertEquals("1772832833109192", templates.data().get(6).id());

        var buttonComponent = (ButtonComponent) templates.data().get(1).components().get(3);

        Assertions.assertEquals(ButtonType.QUICK_REPLY, buttonComponent.getButtons().get(0).getType());


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

    @Test
    void testRetrieveMessageTemplate3WithLimit() throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/retTemplate3.json")));

        var templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID, 1, "10");


        Assertions.assertEquals(1, templates.data().size());
        Assertions.assertEquals("welcome_template3", templates.data().get(0).name());
        Assertions.assertEquals("Hello {{1}}, welcome to our {{2}} test.", templates.data().get(0).components().get(1).getText());

    }

    @Test
    void testRetrievePhoneNumber() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/phone/phoneNumber.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        var phoneNumber = businessManagementApi.retrievePhoneNumber(PHONE_NUMBER_ID);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID, recordedRequest.getPath());

        Assertions.assertEquals("11111111111", phoneNumber.displayPhoneNumber());
        Assertions.assertNull(phoneNumber.nameStatus());
        Assertions.assertEquals(QualityRatingType.GREEN, phoneNumber.qualityRating());
        Assertions.assertEquals("NOT_VERIFIED", phoneNumber.codeVerificationStatus());
        Assertions.assertEquals("109219645287979", phoneNumber.id());

    }

    @Test
    void testRetrievePhoneNumberWithSpecificFields() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/phone/phoneWithSpecificFields.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        var phoneNumber = businessManagementApi.retrievePhoneNumber(PHONE_NUMBER_ID, "name_status", "verified_name");

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "?fields=name_status%2Cverified_name", recordedRequest.getPath());

        Assertions.assertNull(phoneNumber.displayPhoneNumber());
        Assertions.assertEquals(NameStatusType.APPROVED, phoneNumber.nameStatus());
        Assertions.assertEquals("Test Number", phoneNumber.verifiedName());

        Assertions.assertEquals("109219645287979", phoneNumber.id());

    }

    @Test
    void testRetrievePhoneNumbers() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/phone/phoneNumbersList.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        var phoneNumbers = businessManagementApi.retrievePhoneNumbers(WABA_ID);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + WABA_ID + "/phone_numbers", recordedRequest.getPath());

        Assertions.assertNotNull(phoneNumbers.data());
        Assertions.assertNotNull(phoneNumbers.paging());

        Assertions.assertEquals(4, phoneNumbers.data().size());

        var phoneNumber = phoneNumbers.data().get(0);

        Assertions.assertEquals("1111111111", phoneNumber.displayPhoneNumber());
        Assertions.assertNull(phoneNumber.nameStatus());
        Assertions.assertEquals(QualityRatingType.YELLOW, phoneNumber.qualityRating());
        Assertions.assertEquals("NOT_VERIFIED", phoneNumber.codeVerificationStatus());
        Assertions.assertEquals("109219652874979", phoneNumber.id());

    }

    @Test
    void testRetrievePhoneNumberNotFoundError() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(400).setBody(fromResource("/phone/phoneNumberNotFoundError.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        var ex = Assertions.assertThrows(WhatsappApiException.class, () -> businessManagementApi.retrievePhoneNumber("454545"));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + "454545", recordedRequest.getPath());

        Assertions.assertEquals("Unsupported get request. Object with ID '454545' does not exist, cannot be loaded due to missing permissions, or does not support this operation. Please read the Graph API documentation at https://developers.facebook.com/docs/graph-api", ex.getMessage());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#requestCode(String, RequestCode)}}
     */
    @Test
    void requestCode() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/reponse.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        var reponse = businessManagementApi.requestCode(PHONE_NUMBER_ID, new RequestCode(CodeMethodType.SMS, LanguageType.EN_US));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/request_code", recordedRequest.getPath());
        Assertions.assertEquals("{\"code_method\":\"SMS\",\"language\":\"en_US\"}", recordedRequest.getBody().readUtf8());

        Assertions.assertTrue(reponse.success());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#requestCode(String, RequestCode)}}
     */
    @Test
    void requestCodeError() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(400).setBody(fromResource("/phone/requestCodeError.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        var ex = Assertions.assertThrows(WhatsappApiException.class, () -> businessManagementApi.requestCode(PHONE_NUMBER_ID, new RequestCode(CodeMethodType.SMS, LanguageType.EN_US)));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/request_code", recordedRequest.getPath());
        Assertions.assertEquals("{\"code_method\":\"SMS\",\"language\":\"en_US\"}", recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("[136024] Request code error | Tente novamente depois de um tempo.", ex.getMessage());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#verifyCode(String, VerifyCode)}
     */
    @Test
    void verifyCode() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(fromResource("/reponse.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        var reponse = businessManagementApi.verifyCode(PHONE_NUMBER_ID, new VerifyCode("12345678"));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/verify_code", recordedRequest.getPath());
        Assertions.assertEquals("{\"code\":\"12345678\"}", recordedRequest.getBody().readUtf8());

        Assertions.assertTrue(reponse.success());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#verifyCode(String, VerifyCode)}
     */
    @Test
    void verifyCodeError() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(400).setBody(fromResource("/phone/verifyCodeError.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        var ex = Assertions.assertThrows(WhatsappApiException.class, () -> businessManagementApi.verifyCode(PHONE_NUMBER_ID, new VerifyCode("12345678")));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/verify_code", recordedRequest.getPath());
        Assertions.assertEquals("{\"code\":\"12345678\"}", recordedRequest.getBody().readUtf8());

        Assertions.assertEquals("[136025] Verify code error | O código inserido está incorreto.", ex.getMessage());

    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#getWhatsappCommerceSettings(String, String...)}
     */
    @Test
    void getWhatsappCommerceSettings() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(fromResource("/config/commerceSettings.json")));

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        var response = businessManagementApi.getWhatsappCommerceSettings(PHONE_NUMBER_ID, "is_catalog_visible");

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/whatsapp_commerce_settings?fields=is_catalog_visible", recordedRequest.getPath());

        Assertions.assertFalse(response.data().isEmpty());
        Assertions.assertEquals("1001185490903808", response.data().get(0).getId());
        Assertions.assertTrue(response.data().get(0).isCatalogVisible());
    }

    /**
     * Method under test: {@link WhatsappBusinessManagementApi#updateWhatsappCommerceSettings(String, CommerceDataItem)}
     */
    @Test
    void updateWhatsappCommerceSettings() throws IOException, URISyntaxException, InterruptedException {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(fromResource("/reponse.json"))
        );

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessManagementApi businessManagementApi = factory.newBusinessManagementApi();

        CommerceDataItem commerceDataItem = new CommerceDataItem()
                .setCartEnabled(true)
                .setCatalogVisible(true);

        var response = businessManagementApi.updateWhatsappCommerceSettings(PHONE_NUMBER_ID, commerceDataItem);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        Assertions.assertEquals("POST", recordedRequest.getMethod());
        Assertions.assertEquals("/" + API_VERSION + "/" + PHONE_NUMBER_ID + "/whatsapp_commerce_settings", recordedRequest.getPath());

        Assertions.assertTrue(response.success());
    }

}

