package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.ReactionMessage;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;


public class SendIReactionMessageExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        var emojiThumbsUp = "\uD83D\uDC4D";
        var reactionMessage = new ReactionMessage()//
                .setMessageId("wamid.HBgNNTUyNzk5NzAzMDkzNhUCABIYFDNBRjE2OTUyOTNCNTlCM0IzRDQ0AA==")//
                .setEmoji(emojiThumbsUp);//

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildReactionMessage(reactionMessage);

        MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

        System.out.println(messageResponse);

    }
}
