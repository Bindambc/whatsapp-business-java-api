package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;
import static com.whatsapp.api.TestConstants.WABA_ID;

public class RetrievePhoneNumberExample {

    public static void main(String[] args) throws JsonProcessingException {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessManagementApi whatsappBusinessManagementApi = factory.newBusinessManagementApi();

        // one phone number
        retrieveOne(whatsappBusinessManagementApi);

        // one phone number with specifc fields
        retrieveOneWithSpecificFields(whatsappBusinessManagementApi);

        // a list of phone numbers
        retrieveAll(whatsappBusinessManagementApi);

    }

    private static void retrieveOne(WhatsappBusinessManagementApi whatsappBusinessManagementApi) throws JsonProcessingException {
        var phoneNumber = whatsappBusinessManagementApi.retrievePhoneNumber(PHONE_NUMBER_ID);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(phoneNumber));
    }

    private static void retrieveOneWithSpecificFields(WhatsappBusinessManagementApi whatsappBusinessManagementApi) throws JsonProcessingException {

        var phoneNumber = whatsappBusinessManagementApi.retrievePhoneNumber(PHONE_NUMBER_ID, "name_status", "verified_name");

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(phoneNumber));
    }


    private static void retrieveAll(WhatsappBusinessManagementApi whatsappBusinessManagementApi) throws JsonProcessingException {

        var phoneNumbers = whatsappBusinessManagementApi.retrievePhoneNumbers(WABA_ID);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(phoneNumbers));
    }


}
