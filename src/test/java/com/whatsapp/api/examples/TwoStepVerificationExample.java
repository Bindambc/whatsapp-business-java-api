package com.whatsapp.api.examples;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.phone.TwoStepCode;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

public class TwoStepVerificationExample {

	public static void main(String[] args) {
		WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

		WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

		final var twoStepCode = new TwoStepCode("123456");

		var response = whatsappBusinessCloudApi.twoStepVerification(PHONE_NUMBER_ID, twoStepCode);

		System.out.println(response);
	}

}
