# :iphone: Whatsapp Business java api SDK

[![Java CI with Maven](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/maven-ci.yml/badge.svg)](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/maven-ci.yml)
[![CodeQL](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/codeql-analysis.yml)
[![](https://jitpack.io/v/Bindambc/whatsapp-business-java-api.svg)](https://jitpack.io/#Bindambc/whatsapp-business-java-api)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Whatsapp business api SDK, written in java. This SDK implements the Official [Whatsapp Cloud API](https://developers.facebook.com/docs/whatsapp/cloud-api) and [WhatsApp Business Management API](https://developers.facebook.com/docs/whatsapp/business-management-api). These allows you to:
- manage your WhatsApp Business Account assets, such as message templates and phone numbers;
- send messages to your contacts, such as simple text messages, messages with buttons...

:warning: This project is still under construction. Contributions are welcome.

---

## :hammer_and_wrench: Installation

:warning: this library is compatible with **java 17+**.

**1. Add the [JitPack](https://jitpack.io/#Bindambc/whatsapp-business-java-api) repository to your build file:**

```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

**2. Add the following Maven dependency to your project's `pom.xml`:**

```xml
   <dependency>
      <groupId>com.github.Bindambc</groupId>
      <artifactId>whatsapp-business-java-api</artifactId>
      <version>0.0.3</version>
   </dependency>
```

**3. Install library into your Maven's local repository by running `mvn install`**

Alternatively, you can clone this repository and run the [examples](https://github.com/Bindambc/whatsapp-business-java-api/tree/main/src/test/java/com/whatsapp/api/examples).


## :eyes: Overview

There are two client classes that can be used to interact with the API:

1. [`WhatsappBusinessCloudApi`](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/main/java/com/whatsapp/api/impl/WhatsappBusinessCloudApi.java), a synchronous/blocking [WhatsApp Business Platform Cloud API](https://developers.facebook.com/docs/whatsapp/cloud-api) client;
> Send and receive messages using a cloud-hosted version of the WhatsApp Business Platform. The Cloud API allows you to implement WhatsApp Business APIs without the cost of hosting of your own servers and also allows you to more easily scale your business messaging.


```java
 WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);

 WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
```

2. [`WhatsappBusinessManagementApi`](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/main/java/com/whatsapp/api/impl/WhatsappBusinessManagementApi.java), a synchronous/blocking [WhatsApp Business Management API](https://developers.facebook.com/docs/whatsapp/business-management-api) client;
>The WhatsApp Business Management API allows you to programmatically manage your WhatsApp Business Account assets, such as message templates and phone numbers.

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();
 ```

These can be instantiated through the corresponding factory method of [`WhatsappApiFactory`](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/main/java/com/whatsapp/api/WhatsappApiFactory.java), by passing the token, which can be created following the instructions at [whatsapp](https://developers.facebook.com/docs/whatsapp/cloud-api/get-started).

## :scroll: Examples (WhatsApp Business Platform Cloud API)

[**Send a simple text message:**](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendTextMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTextMessage(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false));


        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/211179681-488341bf-a831-48ab-9ea1-312adcb769a4.png)


---        
 [**Send a message with buttons (template):**](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendTemplateButtonMessageExample.java)

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(com.whatsapp.api.domain.templates.Language.PT_BR))//
                                .setName("schedule_confirmation3")//
                                .addComponent(//
                                        new Component(ComponentType.BODY)//
                                                .addParameter(new TextParameter("Mauricio"))//
                                                .addParameter(new TextParameter("04/11/2022"))//
                                                .addParameter(new TextParameter("14:30")))//

                );

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/211179613-3b9a30db-4f2f-4424-8073-adb8fce09226.png)

---
[**Send a message with a contact**](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendContactMessageExample.java)

```java
 WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildContactMessage(new ContactMessage()//
                        .addContacts(new ContactsItem()//
                                .addPhones(new PhonesItem()//
                                        .setPhone(PHONE_NUMBER_1)//
                                        .setType(AddressType.HOME))//
                                .setName(new Name()//
                                        .setFormattedName("Mauricio Binda")//
                                        .setFirstName("Mauricio"))//
                        ));


        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/211179648-e4c97874-a380-49db-8337-39f17e661799.png)


---

## :scroll: Examples (WhatsApp Business Management API)

[**Create a template message**](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/CreateMessageTemplate3Example.java)

```java
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        var template = new MessageTemplate();

        template.setName("schedule_confirmation3")//
                .setCategory(Category.TRANSACTIONAL)//
                .setLanguage(Language.PT_BR)//
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

```

---

### :heavy_plus_sign: [See more examples here](https://github.com/Bindambc/whatsapp-business-java-api/tree/main/src/test/java/com/whatsapp/api/examples).

---

## :arrow_down: WebHooks
Webhooks are triggered when a customer performs an action or the status for a message a business sends a customer changes.

WebHook objects are mapped on [**WebHookPayload class**](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/main/java/com/whatsapp/api/domain/webhook/WebHookPayload.java)
```java
    var objectMapper = new ObjectMapper();
    var obj = objectMapper.readValue(fileContent, WebHookPayload.class);
```

You get a webhooks notification:

1- When a customer performs an action

- Sends a text message to the business
- Sends an image, video, audio, document, or sticker to the business
- Sends contact information to the business
- Sends location information to the business
- Clicks a reply button set up by the business
- Clicks a call-to-actions button on an Ad that Clicks to WhatsApp
- Clicks an item on a business' list
- Updates their profile information such as their phone number
- Asks for information about a specific product
- Orders products being sold by the business

2- When the status for a message received by a business changes (includes pricing information)

- delivered
- read
- sent

3- When WhatsApp Business Management API updates:

- Message Template Updates
- Phone Number Updates
- WABA Updates
