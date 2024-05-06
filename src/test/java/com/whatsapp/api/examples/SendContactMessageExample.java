package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.configuration.ApiVersion;
import com.whatsapp.api.domain.messages.Address;
import com.whatsapp.api.domain.messages.Contact;
import com.whatsapp.api.domain.messages.ContactMessage;
import com.whatsapp.api.domain.messages.Email;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.Name;
import com.whatsapp.api.domain.messages.Org;
import com.whatsapp.api.domain.messages.Phone;
import com.whatsapp.api.domain.messages.Url;
import com.whatsapp.api.domain.messages.type.AddressType;
import com.whatsapp.api.domain.messages.type.EmailType;
import com.whatsapp.api.domain.messages.type.PhoneType;
import com.whatsapp.api.domain.messages.type.UrlType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

public class SendContactMessageExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi(ApiVersion.V18_0);


        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildContactMessage(new ContactMessage()//
                        .addContacts(new Contact()//
                                        .addPhones(new Phone()//
                                                .setPhone(PHONE_NUMBER_1)//
                                                .setType(PhoneType.IPHONE))//
                                        .setName(new Name()//
                                                .setFormattedName("Mauricio Binda")////
                                                .setFirstName("Mauricio"))//
                                        .setOrg(new Org()//
                                                .setTitle("Org title")//
                                                .setCompany("My company")//
                                                .setDepartment("IT"))//
                                        .addEmails(new Email()//
                                                .setType(EmailType.HOME)//
                                                .setEmail("mauriciobinda@hotmail.com")//
                                        )
                                        .addAddresses(new Address()//
                                                .setCity("New York")//
                                                .setCountry("United States")//
                                                .setState("NY")//
                                                .setType(AddressType.WORK)//
                                                .setStreet("47 W 13th St")//
                                                .setZip("10011")//
                                                .setCountryCode("US")//
                                        )
                                        .setBirthday("1900-01-01")
                                        .addUrls(new Url()//
                                                .setType(UrlType.WORK)//
                                                .setUrl("https://www.google.com")//
                                        )

                                //
                        ));


        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

    }
}
