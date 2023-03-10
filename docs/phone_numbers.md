## :scroll: Managing phone numbers

You can:
- Retrieve phone numbers data from a Whatsapp Business Account;
- Retrieve a specific phone number data by id.

See the examples:

#### [Get a phone number data list:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/RetrievePhoneNumberExample.java)

```java
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi();

        var phoneNumbers = whatsappBusinessManagementApi.retrievePhoneNumbers(WABA_ID);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(phoneNumbers));
```

---

#### [Get a phone number data by id:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/RetrievePhoneNumberExample.java)

```java
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi();
        
        var phoneNumber = whatsappBusinessManagementApi.retrievePhoneNumber(PHONE_NUMBER_ID);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(phoneNumber));
```

---

#### [Get a phone number data with specific fields:](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/RetrievePhoneNumberExample.java)

```java
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi();

        var phoneNumber = whatsappBusinessManagementApi.retrievePhoneNumber(PHONE_NUMBER_ID, "name_status", "verified_name");

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(phoneNumber));
```
---
See full examples [here](https://github.com/Bindambc/whatsapp-business-java-api/blob/main/src/test/java/com/whatsapp/api/examples/RetrievePhoneNumberExample.java)

[:arrow_heading_up: back](../README.md#link-links)
