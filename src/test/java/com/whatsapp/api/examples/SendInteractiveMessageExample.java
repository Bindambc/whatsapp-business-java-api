package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.Action;
import com.whatsapp.api.domain.messages.Body;
import com.whatsapp.api.domain.messages.Button;
import com.whatsapp.api.domain.messages.Footer;
import com.whatsapp.api.domain.messages.Header;
import com.whatsapp.api.domain.messages.InteractiveMessage;
import com.whatsapp.api.domain.messages.InteractiveMessageType;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.ProductItem;
import com.whatsapp.api.domain.messages.Reply;
import com.whatsapp.api.domain.messages.Row;
import com.whatsapp.api.domain.messages.Section;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;


public class SendInteractiveMessageExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

//        productMessage(whatsappBusinessCloudApi);

//        multiProductMessage(whatsappBusinessCloudApi);

        buttonMessage(whatsappBusinessCloudApi);

        listMessage(whatsappBusinessCloudApi);

    }

    private static void multiProductMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setCatalogId("1") //
                                .addSection(new Section() //
                                        .setTitle("Title 1") //
                                        .addProductItem(new ProductItem() //
                                                .setProductRetailerId("product-SKU1-in-catalog")) //
                                        .addProductItem(new ProductItem() //
                                                .setProductRetailerId("product-SKU2-in-catalog")) //
                                        .addProductItem(new ProductItem() //
                                                .setProductRetailerId("product-SKU3-in-catalog")) //
                                ) //
                                .addSection(new Section() //
                                        .setTitle("Title 2") //
                                        .addProductItem(new ProductItem() //
                                                .setProductRetailerId("product-SKU5-in-catalog"))) //
                        ) //
                        .setType(InteractiveMessageType.PRODUCT_LIST) //
                        .setHeader(new Header() //
                                .setType("text") //
                                .setText("Header Text")) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }

    private static void productMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setCatalogId("1") //
                                .setProductRetailerId("ID_TEST_ITEM_1")) //
                        .setType(InteractiveMessageType.PRODUCT) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }

    private static void buttonMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .addButton(new Button() //
                                        .setType("reply")
                                        .setReply(new Reply() //
                                                .setId("UNIQUE_BUTTON_ID_1") //
                                                .setTitle("BUTTON_TITLE_1"))) //
                                .addButton(new Button() //
                                        .setType("reply")
                                        .setReply(new Reply() //
                                                .setId("UNIQUE_BUTTON_ID_2") //
                                                .setTitle("BUTTON_TITLE_2")))
                        ) //
                        .setType(InteractiveMessageType.BUTTON) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }

    private static void listMessage(WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildInteractiveMessage(InteractiveMessage.build() //
                        .setAction(new Action() //
                                .setButtonText("BUTTON_TEXT") //
                                .addSection(new Section() //
                                        .setTitle("Title 1") //
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
                                        .setTitle("Title 2") //
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
                                )
                        ) //
                        .setType(InteractiveMessageType.LIST) //
                        .setHeader(new Header() //
                                .setType("text") //
                                .setText("Header Text")) //
                        .setBody(new Body() //
                                .setText("Body message")) //
                        .setFooter(new Footer() //
                                .setText("Footer Text")) //
                );

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);
    }
}
