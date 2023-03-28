package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.Action;
import com.whatsapp.api.domain.messages.Body;
import com.whatsapp.api.domain.messages.Button;
import com.whatsapp.api.domain.messages.Footer;
import com.whatsapp.api.domain.messages.Header;
import com.whatsapp.api.domain.messages.InteractiveMessage;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.Product;
import com.whatsapp.api.domain.messages.Reply;
import com.whatsapp.api.domain.messages.Row;
import com.whatsapp.api.domain.messages.Section;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.domain.messages.type.ButtonType;
import com.whatsapp.api.domain.messages.type.HeaderType;
import com.whatsapp.api.domain.messages.type.InteractiveMessageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;


public class SendInteractiveMessageExample {

    public static void main(String[] args) throws JsonProcessingException {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        productMessage(whatsappBusinessCloudApi);

        multiProductMessage(whatsappBusinessCloudApi);

        buttonMessage(whatsappBusinessCloudApi);

        listMessage(whatsappBusinessCloudApi);

    }

    private static void multiProductMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setCatalogId("6019053994849450") //
                                .addSection(new Section() //
                                        .setTitle("Title 1") //
                                        .addProductItem(new Product() //
                                                .setProductRetailerId("product-SKU1-in-catalog")) //
                                        .addProductItem(new Product() //
                                                .setProductRetailerId("product-SKU2-in-catalog")) //
                                        .addProductItem(new Product() //
                                                .setProductRetailerId("product-SKU3-in-catalog")) //
                                ) //
                                .addSection(new Section() //
                                        .setTitle("Title 2") //
                                        .addProductItem(new Product() //
                                                .setProductRetailerId("product-SKU5-in-catalog"))) //
                        ) //
                        .setType(InteractiveMessageType.PRODUCT_LIST) //
                        .setHeader(new Header() //
                                .setType(HeaderType.TEXT) //
                                .setText("Header Text")) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }

    private static void productMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) throws JsonProcessingException {
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setCatalogId("600136185327014") //
                                .setProductRetailerId("r2d5xse158")) //
                        .setType(InteractiveMessageType.PRODUCT) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        System.out.println(new ObjectMapper().writeValueAsString(message));

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }

    private static void buttonMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) throws JsonProcessingException {
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .addButton(new Button() //
                                        .setType(ButtonType.REPLY).setReply(new Reply() //
                                                .setId("1278454") //
                                                .setTitle("YES"))) //
                                .addButton(new Button() //
                                        .setType(ButtonType.REPLY).setReply(new Reply() //
                                                .setId("1278455") //
                                                .setTitle("NO"))) //
                                .addButton(new Button() //
                                        .setType(ButtonType.REPLY).setReply(new Reply() //
                                                .setId("1278456") //
                                                .setTitle("CHANGE")))) //
                        .setType(InteractiveMessageType.BUTTON) //
                        .setHeader(new Header()//
                                .setType(HeaderType.TEXT)//
                                .setText("Appointment confirmation.")//

                        ).setBody(new Body() //
                                .setText("Would you like to confirm your appointment for tomorrow?")) //
                        .setFooter(new Footer().setText("Choose an option:")));
        System.out.println(new ObjectMapper().writeValueAsString(message));

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }

    private static void listMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) throws JsonProcessingException {
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setButtonText("choose an option") //
                                .addSection(new Section() //
                                        .setTitle("Section 1") //
                                        .addRow(new Row() //
                                                .setId("SECTION_1_ROW_1_ID") //
                                                .setTitle("Title 1") //
                                                .setDescription("SECTION_1_ROW_1_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_1_ROW_2_ID") //
                                                .setTitle("Title 2") //
                                                .setDescription("SECTION_1_ROW_2_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_1_ROW_3_ID") //
                                                .setTitle("Title 3") //
                                                .setDescription("SECTION_1_ROW_3_DESCRIPTION")) //
                                ) //
                                .addSection(new Section() //
                                        .setTitle("Section 2") //
                                        .addRow(new Row() //
                                                .setId("SECTION_2_ROW_1_ID") //
                                                .setTitle("Title 1") //
                                                .setDescription("SECTION_2_ROW_1_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_2_ROW_2_ID") //
                                                .setTitle("Title 2") //
                                                .setDescription("SECTION_2_ROW_2_DESCRIPTION")) //
                                        .addRow(new Row() //
                                                .setId("SECTION_2_ROW_3_ID") //
                                                .setTitle("Title 3") //
                                                .setDescription("SECTION_2_ROW_3_DESCRIPTION")) //
                                )) //
                        .setType(InteractiveMessageType.LIST) //
                        .setHeader(new Header() //
                                .setType(HeaderType.TEXT) //
                                .setText("Header Text")) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                        .setFooter(new Footer() //
                                .setText("Footer Text")) //
                );
        System.out.println(new ObjectMapper().writeValueAsString(message));
        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }
}
