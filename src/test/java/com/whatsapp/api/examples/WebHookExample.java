package com.whatsapp.api.examples;

import com.whatsapp.api.domain.webhook.WebHook;
import com.whatsapp.api.domain.webhook.WebHookEvent;

import java.io.IOException;

public class WebHookExample {

    public static void main(String[] args) throws IOException {
// text message paylod
        var payload = "{\n" +//
                "  \"object\": \"whatsapp_business_account\",\n" +//
                "  \"entry\": [\n" +//
                "    {\n" +//
                "      \"id\": \"880480571844883\",\n" +//
                "      \"changes\": [\n" +//
                "        {\n" +//
                "          \"value\": {\n" +//
                "            \"messaging_product\": \"whatsapp\",\n" +//
                "            \"metadata\": {\n" +//
                "              \"display_phone_number\": \"43330585569\",\n" +//
                "              \"phone_number_id\": \"409552778964973\"\n" +//
                "            },\n" +//
                "            \"contacts\": [\n" +//
                "              {\n" +//
                "                \"profile\": {\n" +//
                "                  \"name\": \"Mauricio Binda\"\n" +//
                "                },\n" +//
                "                \"wa_id\": \"1111111111111\"\n" +//
                "              }\n" +//
                "            ],\n" +//
                "            \"messages\": [\n" +//
                "              {\n" +//
                "                \"from\": \"409552778964973\",\n" +//
                "                \"id\": \"wamid.nBgN6TUyN2k5NzAzM5kzNhUCABI8FDNFQjAxQkE5REI4NEUzQ5Y5QTNgAA==\",\n" +//
                "                \"timestamp\": \"1673020315\",\n" +//
                "                \"text\": {\n" +//
                "                  \"body\": \"Good afternoon\"\n" +//
                "                },\n" +//
                "                \"type\": \"text\"\n" +//
                "              }\n" +//
                "            ]\n" +//
                "          },\n" +//
                "          \"field\": \"messages\"\n" +//
                "        }\n" +//
                "      ]\n" +//
                "    }\n" +//
                "  ]\n" +//
                "}";

        WebHookEvent event = WebHook.constructEvent(payload);

        System.out.println(event);

    }
}
