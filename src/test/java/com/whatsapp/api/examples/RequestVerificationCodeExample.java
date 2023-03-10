package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.phone.RequestCode;
import com.whatsapp.api.domain.phone.VerifyCode;
import com.whatsapp.api.domain.phone.type.CodeMethodType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;

public class RequestVerificationCodeExample {

    public static void main(String[] args) throws JsonProcessingException {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi();
        //request the code
        var response = whatsappBusinessManagementApi.requestCode(PHONE_NUMBER_ID, new RequestCode(CodeMethodType.SMS, LanguageType.EN_US));

        System.out.println(response);

        //verify the code
        var response2 = whatsappBusinessManagementApi.verifyCode(PHONE_NUMBER_ID, new VerifyCode("0000"));

        System.out.println(response2);

    }
}