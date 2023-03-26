package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.BodyComponent;
import com.whatsapp.api.domain.messages.ButtonComponent;
import com.whatsapp.api.domain.messages.ButtonPayloadParameter;
import com.whatsapp.api.domain.messages.DateTime;
import com.whatsapp.api.domain.messages.DateTimeParameter;
import com.whatsapp.api.domain.messages.Language;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.TemplateMessage;
import com.whatsapp.api.domain.messages.TextParameter;
import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.messages.type.CalendarType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

public class SendTemplateButtonMessage2Example {
    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(LanguageType.PT_BR))//
                                .setName("schedule_confirmation3")//
                                .addComponent(new BodyComponent()//
                                        .addParameter(new TextParameter("Mauricio"))//
                                        .addParameter(new DateTimeParameter()//
                                                .setDateTime(new DateTime()//
                                                        .setCalendar(CalendarType.GREGORIAN)//
                                                        .setDayOfMonth(25)//
                                                        .setMonth(3)//
                                                        .setYear(2023)//
                                                        .setHour(13)
                                                        .setMinute(50)
                                                        .setDayOfWeek(7)
                                                        .setFallbackValue("25/03/2023")//
                                                ))//
                                        .addParameter(new DateTimeParameter()//
                                                .setDateTime(new DateTime()//
                                                        .setHour(14)//
                                                        .setMinute(30)//
                                                        .setFallbackValue("14:34")//
                                                )))//

                                .addComponent(new ButtonComponent()//
                                        .setIndex(0)//
                                        .setSubType(ButtonSubType.QUICK_REPLY)//
                                        .addParameter(new ButtonPayloadParameter("OP_YES_48547")))//
                                .addComponent(new ButtonComponent()//
                                        .setIndex(1)//
                                        .setSubType(ButtonSubType.QUICK_REPLY)//
                                        .addParameter(new ButtonPayloadParameter("OP_NO_48548")))//
                                .addComponent(new ButtonComponent(2, ButtonSubType.QUICK_REPLY)//
                                        .addParameter(new ButtonPayloadParameter("OP_CH_48549")))//


                );
        System.out.println(new ObjectMapper().writeValueAsString(message));

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}
