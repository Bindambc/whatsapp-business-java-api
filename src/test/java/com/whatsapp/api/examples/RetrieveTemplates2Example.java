package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.WABA_ID;

public class RetrieveTemplates2Example {

    public static void main(String[] args) throws JsonProcessingException {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessCloudApi = factory.newBusinessManagementApi();

        var templates = whatsappBusinessCloudApi.retrieveTemplates(WABA_ID, 2);

        ObjectMapper mapper = new ObjectMapper();


        System.out.println(mapper.writeValueAsString(templates));
    }
}
