package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.BodyComponent;
import com.whatsapp.api.domain.messages.ButtonComponent;
import com.whatsapp.api.domain.messages.ButtonPayloadParameter;
import com.whatsapp.api.domain.messages.Currency;
import com.whatsapp.api.domain.messages.CurrencyParameter;
import com.whatsapp.api.domain.messages.DateTime;
import com.whatsapp.api.domain.messages.DateTimeParameter;
import com.whatsapp.api.domain.messages.HeaderComponent;
import com.whatsapp.api.domain.messages.Image;
import com.whatsapp.api.domain.messages.ImageParameter;
import com.whatsapp.api.domain.messages.Language;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.TemplateMessage;
import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.messages.type.CalendarType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

public class SendTemplateMarketingMessageExample {
    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();


        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(LanguageType.EN_US))//
                                .setName("marketing_music_2")//
                                .addComponent(new HeaderComponent()//
                                        .addParameter(new ImageParameter()//
                                                .setImage(new Image()//
                                                        .setId("3196424913981611")//
                                                )
                                        )).addComponent(//
                                        new BodyComponent()//
                                                .addParameter(new DateTimeParameter()//
                                                        .setDateTime(new DateTime()//
                                                                .setCalendar(CalendarType.GREGORIAN)//
                                                                .setDayOfMonth(26)//
                                                                .setMonth(3)//
                                                                .setYear(2023)//
                                                                .setHour(10)
                                                                .setMinute(50)
                                                                .setDayOfWeek(1).setFallbackValue("May 10th, 2023")//
                                                        ))//
                                                .addParameter(new CurrencyParameter()//
                                                        .setCurrency(new Currency("$35", "USD", 30000))))//

                                .addComponent(new ButtonComponent()//
                                        .setIndex(0)//
                                        .setSubType(ButtonSubType.QUICK_REPLY)//
                                        .addParameter(new ButtonPayloadParameter("OP_SHN_454584")))//
                                .addComponent(new ButtonComponent()//
                                        .setIndex(1)//
                                        .setSubType(ButtonSubType.QUICK_REPLY)//
                                        .addParameter(new ButtonPayloadParameter("OP_SPR_454585")))//
                );
        System.out.println(new ObjectMapper().writeValueAsString(message));

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}
