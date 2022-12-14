package com.whatsapp.api.examples;

import com.whatsapp.api.TestUtils;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.AddressType;
import com.whatsapp.api.domain.messages.ContactMessage;
import com.whatsapp.api.domain.messages.ContactsItem;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.Name;
import com.whatsapp.api.domain.messages.PhonesItem;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestUtils.PHONE_NUMBER_1;
import static com.whatsapp.api.TestUtils.PHONE_NUMBER_ID;

public class SendContactMessageExample {

    public static void main(String[] args) {

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

    }
}
