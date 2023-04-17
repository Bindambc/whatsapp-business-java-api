package com.whatsapp.api.examples;

import static com.whatsapp.api.TestConstants.TOKEN;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

public class MarkMessageAsReadExample {

	public static void main(String[] args) {
		 WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        Message message = MessageBuilder.builder().buildMarkAsReadMessage("123456");
        //Mark message as read
        var response = whatsappBusinessCloudApi.markMessageAsRead(TOKEN, message);

        System.out.println(response);
	}

}
