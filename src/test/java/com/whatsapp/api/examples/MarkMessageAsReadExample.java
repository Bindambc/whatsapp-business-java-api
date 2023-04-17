package com.whatsapp.api.examples;

import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.ReadMessage;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

public class MarkMessageAsReadExample {

	public static void main(String[] args) {
		 WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        ReadMessage message = new ReadMessage("123456");
        //Mark message as read
        var response = whatsappBusinessCloudApi.markMessageAsRead(PHONE_NUMBER_ID, message);

        System.out.println(response);
	}

}
