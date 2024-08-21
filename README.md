# [ <img src="https://user-images.githubusercontent.com/7831956/222028018-181cf927-781c-40a9-af7a-e3c3d1e39390.png" width="68" height="68"> Whatsapp Business java api SDK](https://bindambc.github.io/whatsapp-business-java-api/)

[![Java CI with Maven](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/maven-ci.yml/badge.svg)](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/maven-ci.yml)
[![CodeQL](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/codeql-analysis.yml)
[![](https://jitpack.io/v/Bindambc/whatsapp-business-java-api.svg)](https://jitpack.io/#Bindambc/whatsapp-business-java-api)
[![Javadoc](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/javadoc.yml/badge.svg)](https://github.com/Bindambc/whatsapp-business-java-api/actions/workflows/javadoc.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![codecov](https://codecov.io/gh/Bindambc/whatsapp-business-java-api/branch/main/graph/badge.svg?token=USE7JJSDTV)](https://codecov.io/gh/Bindambc/whatsapp-business-java-api)

Whatsapp business api SDK, written in java. This SDK implements the Official [Whatsapp Cloud API](https://developers.facebook.com/docs/whatsapp/cloud-api) and [WhatsApp Business Management API](https://developers.facebook.com/docs/whatsapp/business-management-api). These allows you to:
- manage your WhatsApp Business Account assets, such as message templates and phone numbers;
- send messages to your contacts, such as simple text messages, messages with buttons, video, images, sticker...
- upload, delete and retrieve media files.
- receive webhooks events

The WhatsApp Business API allows medium and large businesses to communicate with their customers at scale. Using the API, businesses can build systems that connect thousands of customers with agents or bots, enabling both programmatic and manual communication. Additionally, you can integrate the API with numerous backend systems, such as CRM and marketing platforms.The library is designed to be simple and flexible, making it ideal for a wide range of use cases.

This SDK supports WhatsApp Business API versions from v16.0 onwards. [See api changelog](https://developers.facebook.com/docs/whatsapp/business-platform/changelog)

:warning: This project is still under construction. Contributions are welcome.

---
																     
## :link: Links:

- [:hammer_and_wrench: Installation](#hammer_and_wrench-installation)
	- [Maven](#maven)
	- [Gradle](#gradle)
- [:eyes: Overview](#eyes-overview)
- [:eyes: Proxy](#eyes-proxy)
- [:scroll: Examples (Proxy)](#scroll-examples-proxy)
        - [Direct proxy without authentication credentials:](#direct-proxy-without-authentication-credentials)
        - [With authentication credentials:](#with-authentication-credentials)
- [:scroll: Examples (Sending messages)](#scroll-examples-sending-messages)
	- [Sending a simple text message](#sending-a-simple-text-message)
	- [Sending a message with buttons (template)](#sending-a-message-with-buttons-template)
	- [Sending a message with a contact](#sending-a-message-with-a-contact)
	- [Sending an interactive message with buttons](#sending-an-interactive-message-with-buttons)
	- [Sending an interactive message with a list](#sending-an-interactive-message-with-a-list)
	- [Sending an audio message](#sending-an-audio-message)
	- [Sending a document message](#sending-a-document-message)
	- [Sending an image link message](#sending-an-image-link-message)
	- [Sending an image message](#sending-an-image-message)
	- [Sending a sticker message](#sending-a-sticker-message)
	- [Sending a video message](#sending-a-video-message)
- [:scroll: Examples (WhatsApp Business Management API)](#scroll-examples-whatsapp-business-management-api)
	- [Creating a message template](#create-a-message-template)
	- [Managing phone numbers](/docs/phone_numbers.md#scroll-managing-phone-numbers)
	- [Getting verification codes and verifying them.](docs/verification_codes.md#scroll-get-verification-codes-and-verify-then)
- [:arrow_down: WebHooks](#arrow_down-webhooks)
- [:paperclip: Media](#paperclip-media)
	- [Uploading media](#uploading-media)
	- [Retrieving the URL for a specific media](#retrieving-the-url-for-a-specific-media)
	- [Deleting media](#deleting-a-specific-media)
	- [downloading media](#downloading-media-from-a-media-url)
- [:loudspeaker: Call to Action](#loudspeaker-call-to-action)
- [:hammer_and_wrench: Get Involved](#hammer_and_wrench-get-involved)
- [:open_file_folder: Examples folder](https://github.com/Bindambc/whatsapp-business-java-api/tree/main/src/test/java/com/whatsapp/api/examples)


**See [javadoc](https://bindambc.github.io/whatsapp-business-java-api/javadoc/)**

---


## :hammer_and_wrench: Installation

:warning: this library is compatible with **java 17+**.

### Maven

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
      <version>v0.6.1</version>
   </dependency>
```

### Gradle:

**1. Add it in your root build.gradle at the end of repositories:**

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**2. Add the dependency**

```gradle
	dependencies {
	        implementation 'com.github.Bindambc:whatsapp-business-java-api:v0.6.1'
	}
```

**3. Install library into your Maven's local repository by running `mvn install`**

Alternatively, you can clone this repository and run the [examples](https://github.com/Bindambc/whatsapp-business-java-api/tree/main/src/test/java/com/whatsapp/api/examples).

[:arrow_heading_up: back](#link-links)

---

## :eyes: Overview

There are two client classes that can be used to interact with the API:

1. [`WhatsappBusinessCloudApi`](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/main/java/com/whatsapp/api/impl/WhatsappBusinessCloudApi.java), a synchronous/blocking [WhatsApp Business Platform Cloud API](https://developers.facebook.com/docs/whatsapp/cloud-api) client;
> Send and receive messages using a cloud-hosted version of the WhatsApp Business Platform. The Cloud API allows you to implement WhatsApp Business APIs without the cost of hosting of your own servers and also allows you to more easily scale your business messaging.


```java
 WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);

 WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(ApiVersion.V19_0);
```

2. [`WhatsappBusinessManagementApi`](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/main/java/com/whatsapp/api/impl/WhatsappBusinessManagementApi.java), a synchronous/blocking [WhatsApp Business Management API](https://developers.facebook.com/docs/whatsapp/business-management-api) client;
>The WhatsApp Business Management API allows you to programmatically manage your WhatsApp Business Account assets, such as message templates and phone numbers.

```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi(ApiVersion.V19_0);
 ```

These can be instantiated through the corresponding factory method of [`WhatsappApiFactory`](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/main/java/com/whatsapp/api/WhatsappApiFactory.java), by passing the token, which can be created following the instructions at [whatsapp](https://developers.facebook.com/docs/whatsapp/cloud-api/get-started).

[:arrow_heading_up: back](#link-links)

---
## :eyes: Proxy 

You can add a proxy to the api by calling the method `setHttpProxy(...)` of class [`WhatsappApiServiceGenerator`](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/main/java/com/whatsapp/api/WhatsappApiServiceGenerator.java)

```java
public static void setHttpProxy(String host, int port, String username, String pwd)
``` 
Call this method __before__ create the api instance like:

```java
// Set http proxy with credentials before the creation of the api instance
WhatsappApiServiceGenerator.setHttpProxy("<YOUR_PROXY_HOST>", "<YOUR_PROXY_PORT>", "<YOUR_PROXY_USERNAME>", "<YOUR_PROXY_PWD>");

// Create the api instance
WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
```

### :scroll: Examples (Proxy):

#### [Direct proxy without authentication credentials:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/proxy/SendMessageByProxyNoCredentials.java)
```java
   WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        // Set http proxy without credentials before the creation of the api instance
        WhatsappApiServiceGenerator.setHttpProxy("localhost", 8080, null,null);
        
        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTextMessage(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false));

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
```
#### [With authentication credentials:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/proxy/SendMessageByProxyNoCredentials.java)
```java
 WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        // Set http proxy with credentials before the creation of the api instance
        WhatsappApiServiceGenerator.setHttpProxy("localhost", 8080, "username", "password");
        
        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTextMessage(new TextMessage()//
                        .setBody(Formatter.bold("Hello world!") + "\nSome code here: \n" + Formatter.code("hello world code here"))//
                        .setPreviewUrl(false));

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
```

[:arrow_heading_up: back](#link-links)


## :scroll: Examples (Sending messages)

#### [Sending a simple text message:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendTextMessageExample.java)

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

[:arrow_heading_up: back](#link-links)

---        
#### [Sending a message with buttons (template):](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendTemplateButtonMessageExample.java)

```java
	WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(LanguageType.PT_BR))//
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

[:arrow_heading_up: back](#link-links)

---
#### [Sending a message with a contact](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendContactMessageExample.java)

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

[:arrow_heading_up: back](#link-links)

---

#### [Sending an interactive message with buttons:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendInteractiveMessageExample.java)

```java
 	WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
	
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .addButton(new Button() //
                                        .setType(ButtonType.REPLY)
                                        .setReply(new Reply() //
                                                .setId("UNIQUE_BUTTON_ID_1") //
                                                .setTitle("BUTTON_TITLE_1"))) //
                                .addButton(new Button() //
                                        .setType(ButtonType.REPLY)
                                        .setReply(new Reply() //
                                                .setId("UNIQUE_BUTTON_ID_2") //
                                                .setTitle("BUTTON_TITLE_2")))
                        ) //
                        .setType(InteractiveMessageType.BUTTON) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/221338759-b037cae5-6ed6-4b90-91c8-0541e7e19243.png)

[:arrow_heading_up: back](#link-links)

---

#### [Sending an interactive message with a list:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendInteractiveMessageExample.java)

```java
 	WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
	
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setButtonText("BUTTON_TEXT") //
                                .addSection(new Section() //
                                        .setTitle("Title 1") //
                                        .addRow(new Row() //
                                                .setId("SECTION_1_ROW_1_ID") //
                                                .setTitle("Title 1") //
                                                .setDescription("SECTION_1_ROW_1_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_1_ROW_2_ID") //
                                                .setTitle("Title 2") //
                                                .setDescription("SECTION_1_ROW_2_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_1_ROW_3_ID") //
                                                .setTitle("Title 3") //
                                                .setDescription("SECTION_1_ROW_3_DESCRIPTION")) //
                                ) //
                                .addSection(new Section() //
                                        .setTitle("Title 2") //
                                        .addRow(new Row() //
                                                .setId("SECTION_2_ROW_1_ID") //
                                                .setTitle("Title 1") //
                                                .setDescription("SECTION_2_ROW_1_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_2_ROW_2_ID") //
                                                .setTitle("Title 2") //
                                                .setDescription("SECTION_2_ROW_2_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_2_ROW_3_ID") //
                                                .setTitle("Title 3") //
                                                .setDescription("SECTION_2_ROW_3_DESCRIPTION")) //
                                )
                        ) //
                        .setType(InteractiveMessageType.LIST) //
                        .setHeader(new Header() //
                                .setType(HeaderType.TEXT) //
                                .setText("Header Text")) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                        .setFooter(new Footer() //
                                .setText("Footer Text")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/221338815-81ece610-225f-485e-a9f5-bf3d034a5b2a.png)

![image](https://user-images.githubusercontent.com/7831956/221338845-a2e19ba7-c6d5-4247-96e2-e0df163b89f2.png)

[:arrow_heading_up: back](#link-links)

---

#### [Sending an audio message:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendAudioMessageExample.java)

```java
		WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

		WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

		var audioMessage = new AudioMessage()//
		.setId("6418001414900549");

		var message = MessageBuilder.builder()//
		.setTo(PHONE_NUMBER_1)//
		.buildAudioMessage(audioMessage);


		MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/221338759-b037cae5-6ed6-4b90-91c8-0541e7e19243.png)

[:arrow_heading_up: back](#link-links)

---

#### [Sending a document message:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendDocumentMessageExample.java)

```java

		WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

		WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

		var documentMessage = new DocumentMessage()//
		.setId("1238834210396519")// media id (uploaded before)
		.setCaption("Media Object details from developers.facebook.com")//
		.setFileName("Media oject.pdf");

		var message = MessageBuilder.builder()//
		.setTo(PHONE_NUMBER_1)//
		.buildDocumentMessage(documentMessage);


		MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/222820774-489b54fa-4975-4688-927a-09157fb54777.png)


[:arrow_heading_up: back](#link-links)

---

#### [Sending an image link message:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendImageLinkMessageExample.java)

```java
		WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

		WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

		var imageMessage = new ImageMessage()//
		.setLink("https://upload.wikimedia.org/wikipedia/pt/4/45/Yoda.jpg").setCaption("See this image, please");

		var message = MessageBuilder.builder()//
		.setTo(PHONE_NUMBER_1)//
		.buildImageMessage(imageMessage);


		MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

```
![image](https://user-images.githubusercontent.com/7831956/222820971-f27cdb60-9b93-4a8f-96c3-0740bbada95b.png)


[:arrow_heading_up: back](#link-links)

---

#### [Sending an image message:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendImageMessageExample.java)

```java
		WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

		WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

		var imageMessage = new ImageMessage()//
		.setId("186057067456357")// media id (uploaded before)
		.setCaption("See this image, please");

		var message = MessageBuilder.builder()//
		.setTo(PHONE_NUMBER_1)//
		.buildImageMessage(imageMessage);


		MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/222820870-3913c340-2f61-4622-bddc-c0863ec03e7d.png)


[:arrow_heading_up: back](#link-links)

---

#### [Sending a sticker message:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendStickerExample.java)

```java
	WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var stickerMessage = new StickerMessage()//
                .setId("527984052814860");// media id (uploaded before)


        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildStickerMessage(stickerMessage);


        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
```

**Result:**

![image](https://user-images.githubusercontent.com/7831956/222821074-a7f0d1c4-e68e-4350-b108-7c97bccf17bb.png)


[:arrow_heading_up: back](#link-links)

---

#### [Sending a video message:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/SendVideoStickerExample.java)

```java
		WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

		WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

		var videoMessage = new VideoMessage()//
		.setId("1236364143659727")// media id (uploaded before)
		.setCaption("See this video");


		var message = MessageBuilder.builder()//
		.setTo(PHONE_NUMBER_1)//
		.buildVideoMessage(videoMessage);


		MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
```

[:arrow_heading_up: back](#link-links)

---

## :scroll: Examples (WhatsApp Business Management API)

#### [Create a message template](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/CreateMessageTemplate3Example.java)

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

[:arrow_heading_up: back](#link-links)

---

## :arrow_down: WebHooks
Webhooks are triggered when a customer performs an action or the status for a message a business sends a customer changes.

WebHook objects are mapped on [**WebHookEvent class**](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/main/java/com/whatsapp/api/domain/webhook/WebHookEvent.java)

See [Whatsapp api documentation](https://developers.facebook.com/docs/whatsapp/cloud-api/webhooks) for more details.
**Example:**

```java
//payload = the webhook payload json sent by Whatsapp
//using WebHook.constructEvent() to deserialize event
WebHookEvent event = WebHook.constructEvent(payload);
```
See an example [here](https://github.com/Bindambc/whatsapp-business-java-api/tree/main/src/test/java/com/whatsapp/api/examples/WebHookExample.java)

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

[:arrow_heading_up: back](#link-links)

---

## :paperclip: Media

You can use 4 different endpoints to manage your media:

- Upload media.
- Retrieve the URL for a specific media.
- Delete a specific media.
- Download media from a media URL.

**See the examples:**

#### [Uploading media](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/UploadMediaExample.java)

```java
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();


        var fileName = "starwars.png";

        byte[] fileContent = Files.readAllBytes(Paths.get("src/test/resources/" + fileName));


        var response = whatsappBusinessCloudApi.uploadMedia(PHONE_NUMBER_ID, fileName, FileType.PNG, fileContent);

        System.out.println(response);
```
[:arrow_heading_up: back](#link-links)

#### [Retrieving the URL for a specific media](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/RetrieveMediaUrlExample.java)

```java
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var response = whatsappBusinessCloudApi.retrieveMediaUrl("1227829768162607");

        System.out.println(response);
```
[:arrow_heading_up: back](#link-links)

#### [Deleting a specific media](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/DeleteMediaExample.java)

```java
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        //delete media
        var response = whatsappBusinessCloudApi.deleteMedia("723050006231302");

        System.out.println(response);
```
[:arrow_heading_up: back](#link-links)

#### [Downloading media from a media URL](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/DownloadMediaExample.java)

```java
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        // retrieve the media file url
        var mediaUrl = whatsappBusinessCloudApi.retrieveMediaUrl("723050006231302");

        //call downloadMediaFile() -> return a MediaFile object with the file name and content (byte[])
        var mediaFile = whatsappBusinessCloudApi.downloadMediaFile(mediaUrl.url());

        //write the file in the folder "/examples/"
        Files.write(Path.of("src/test/java/com/whatsapp/api/examples/" + mediaFile.fileName()), mediaFile.content());
```
[:arrow_heading_up: back](#link-links)

## :loudspeaker: Call to Action 

We hope that you've found this documentation helpful and that you're excited to start using the WhatsApp Business Java API! Whether you're a developer looking to integrate WhatsApp Business functionality into your application or a user interested in contributing to the project, there are many ways to get involved.

Try out the API today and see how it can enhance your messaging capabilities. We'd also love to hear your feedback and suggestions for how we can improve the library, so please feel free to open an issue or submit a pull request on our GitHub page.

Thank you for your interest in the WhatsApp Business Java API! We look forward to working with you.

## :hammer_and_wrench: Get Involved 

[Contributing:](https://github.com/Bindambc/whatsapp-business-java-api/issues)

We welcome contributions from anyone who is interested in helping to improve this project. If you would like to contribute, here are a few ways you can get involved:

Report issues: If you find a bug or have a suggestion for how to improve the library, please open an issue on the project's GitHub page.

Submit pull requests: If you have code changes you'd like to contribute, please submit a pull request on the project's GitHub page. Before submitting, please make sure your changes adhere to the project's code style and that all tests pass.

Spread the word: If you find the library useful, please tell others about it! You can share the project on social media, write a blog post about it, or mention it in a conference talk.

By contributing to this project, you will be helping to make it better for everyone who uses it. Thank you for your support!


