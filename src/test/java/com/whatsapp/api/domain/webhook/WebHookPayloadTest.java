package com.whatsapp.api.domain.webhook;

import com.whatsapp.api.TestUtils;
import com.whatsapp.api.domain.messages.type.MessageType;
import com.whatsapp.api.domain.webhook.type.EventType;
import com.whatsapp.api.domain.webhook.type.FieldType;
import com.whatsapp.api.domain.webhook.type.MessageStatus;
import com.whatsapp.api.domain.webhook.type.RestrictionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

class WebHookPayloadTest extends TestUtils {

    private final String JSON_FOLDER = "/deserialization/";

    @Test
    void testDeserializationTextMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "textMessage.json");


        var obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals("hi everyone!", obj.entry().get(0).changes().get(0).value().messages().get(0).text().body());
        Assertions.assertEquals(MessageType.TEXT, obj.entry().get(0).changes().get(0).value().messages().get(0).type());


    }

    @Test
    void testDeserializationTextMessage2() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "textMessage2.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().contacts().isEmpty());

        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals("Good afternoon", obj.entry().get(0).changes().get(0).value().messages().get(0).text().body());
        Assertions.assertEquals(MessageType.TEXT, obj.entry().get(0).changes().get(0).value().messages().get(0).type());


    }

    @Test
    void testDeserializationTextMessageSent() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "textMessageStatusSent.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry());
        Assertions.assertFalse(obj.entry().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0));


        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals(MessageStatus.SENT, obj.entry().get(0).changes().get(0).value().statuses().get(0).status());

        Assertions.assertEquals("8eb644d2350611f3746e7f0985bddfc1", obj.entry().get(0).changes().get(0).value().statuses().get(0).conversation().id());
        Assertions.assertEquals("1673031000", obj.entry().get(0).changes().get(0).value().statuses().get(0).conversation().expirationTimestamp());
        Assertions.assertEquals("business_initiated", obj.entry().get(0).changes().get(0).value().statuses().get(0).conversation().origin().type());


        Assertions.assertTrue(obj.entry().get(0).changes().get(0).value().statuses().get(0).pricing().billable());
        Assertions.assertEquals("CBP", obj.entry().get(0).changes().get(0).value().statuses().get(0).pricing().pricingModel());
        Assertions.assertEquals("business_initiated", obj.entry().get(0).changes().get(0).value().statuses().get(0).pricing().category());


    }

    @Test
    void testDeserializationTextMessageDelivered() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "textMessageStatusDelivered.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry());
        Assertions.assertFalse(obj.entry().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0));
        Assertions.assertNotNull(obj.entry().get(0).changes());
        Assertions.assertFalse(obj.entry().get(0).changes().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).field());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().statuses());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().statuses().isEmpty());


        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals(MessageStatus.DELIVERED, obj.entry().get(0).changes().get(0).value().statuses().get(0).status());


    }

    @Test
    void testDeserializationTextMessageRead() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "textMessageStatusRead.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry());
        Assertions.assertFalse(obj.entry().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0));
        Assertions.assertNotNull(obj.entry().get(0).changes());
        Assertions.assertFalse(obj.entry().get(0).changes().isEmpty());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).field());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().statuses());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().statuses().isEmpty());


        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals(MessageStatus.READ, obj.entry().get(0).changes().get(0).value().statuses().get(0).status());


    }

    @Test
    void testDeserializationButtonMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "buttonMessage.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().contacts().isEmpty());

        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.entry().get(0).changes().get(0).field());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).context());
        Assertions.assertEquals(MessageType.BUTTON, obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).button());

    }


    @Test
    void testDeserializationMessageDeleted() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "messageDeleted.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().contacts().isEmpty());


        Assertions.assertEquals(MessageType.UNSUPPORTED, obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).errors());
        var erro = obj.entry().get(0).changes().get(0).value().messages().get(0).errors().get(0);
        Assertions.assertEquals("Message type unknown", erro.message());
        Assertions.assertEquals(131051, erro.code());
        Assertions.assertEquals("Message type unknown", erro.title());
        Assertions.assertEquals("Message type is currently not supported.", erro.errorData().details());


    }

    @Test
    void testDeserializationReactMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "reactMessage.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().contacts().isEmpty());

        Assertions.assertEquals(1, obj.entry().size());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());
        Assertions.assertEquals(1, obj.entry().get(0).changes().size());
        Assertions.assertEquals(FieldType.MESSAGES, obj.entry().get(0).changes().get(0).field());

        Assertions.assertEquals(MessageType.REACTION, obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).reaction());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().messages().get(0).reaction().messageId());

    }


    @Test
    void testDeserializationStickerMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "stickerMessage.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("whatsapp_business_account", obj.object());
        Assertions.assertFalse(obj.entry().isEmpty());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());

        Assertions.assertFalse(obj.entry().get(0).changes().isEmpty());

        Assertions.assertEquals(MessageType.STICKER, obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertEquals("image/webp", obj.entry().get(0).changes().get(0).value().messages().get(0).sticker().mimeType());
        Assertions.assertFalse(obj.entry().get(0).changes().get(0).value().messages().get(0).sticker().animated());
        Assertions.assertEquals("1604825680670873", obj.entry().get(0).changes().get(0).value().messages().get(0).sticker().id());

    }

    @Test
    void testDeserializationVideoMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "videoMessage.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("whatsapp_business_account", obj.object());
        Assertions.assertFalse(obj.entry().isEmpty());
        Assertions.assertEquals("880480571844883", obj.entry().get(0).id());

        Assertions.assertEquals("whatsapp", obj.entry().get(0).changes().get(0).value().messagingProduct());
        Assertions.assertEquals("43330585569", obj.entry().get(0).changes().get(0).value().metadata().displayPhoneNumber());
        Assertions.assertEquals("409552778964973", obj.entry().get(0).changes().get(0).value().metadata().phoneNumberId());

        Assertions.assertEquals("1111111111111", obj.entry().get(0).changes().get(0).value().contacts().get(0).waId());
        Assertions.assertEquals("1111111111111", obj.entry().get(0).changes().get(0).value().contacts().get(0).waId());
        Assertions.assertEquals("Mauricio Binda", obj.entry().get(0).changes().get(0).value().contacts().get(0).profile().name());


        Assertions.assertEquals("1111111111111", obj.entry().get(0).changes().get(0).value().messages().get(0).from());
        Assertions.assertEquals("wamid.HBgNNTUyNzk5NzAzMDkzNhUCABIYFDNFQjAwQjVGQUFGOEVDMTUyMTJBAA==", obj.entry().get(0).changes().get(0).value().messages().get(0).id());
        Assertions.assertEquals("1673029501", obj.entry().get(0).changes().get(0).value().messages().get(0).timestamp());
        Assertions.assertEquals(MessageType.VIDEO, obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertEquals("video/mp4", obj.entry().get(0).changes().get(0).value().messages().get(0).video().mimeType());
        Assertions.assertEquals("hello world", obj.entry().get(0).changes().get(0).value().messages().get(0).video().caption());
        Assertions.assertEquals("waIq5BBe5GgjT6DHWu3LY9F8jYOZzYLHRRRGDTbipNk=", obj.entry().get(0).changes().get(0).value().messages().get(0).video().sha256());
        Assertions.assertEquals("661828760183585", obj.entry().get(0).changes().get(0).value().messages().get(0).video().id());

    }

    @Test
    void testDeserializationImageMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "imageMessage.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673032525", obj.entry().get(0).changes().get(0).value().messages().get(0).timestamp());
        Assertions.assertEquals(MessageType.IMAGE, obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertEquals("image/jpeg", obj.entry().get(0).changes().get(0).value().messages().get(0).image().mimeType());
        Assertions.assertEquals("ciJuSxU7RLnnFz3cNcasdL7UQKt9e1yj/3u+Rhsabv0=", obj.entry().get(0).changes().get(0).value().messages().get(0).image().sha256());
        Assertions.assertEquals("8472976218001204", obj.entry().get(0).changes().get(0).value().messages().get(0).image().id());

    }

    @Test
    void testDeserializationAudioMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "audioMessage.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673033070", obj.entry().get(0).changes().get(0).value().messages().get(0).timestamp());
        Assertions.assertEquals(MessageType.AUDIO, obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertEquals("audio/ogg; codecs=opus", obj.entry().get(0).changes().get(0).value().messages().get(0).audio().mimeType());
        Assertions.assertEquals("iWa0+O81ZLcSkZx6n4QAmrWuHpn8HWFX3gB6a3fQtmk=", obj.entry().get(0).changes().get(0).value().messages().get(0).audio().sha256());
        Assertions.assertEquals("827776106019109", obj.entry().get(0).changes().get(0).value().messages().get(0).audio().id());
        Assertions.assertTrue(obj.entry().get(0).changes().get(0).value().messages().get(0).audio().voice());

    }

    @Test
    void testDeserializationDocumentMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "documentMessage.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673034392", obj.entry().get(0).changes().get(0).value().messages().get(0).timestamp());
        Assertions.assertEquals(MessageType.DOCUMENT, obj.entry().get(0).changes().get(0).value().messages().get(0).type());
        Assertions.assertEquals("application/pdf", obj.entry().get(0).changes().get(0).value().messages().get(0).document().mimeType());
        Assertions.assertEquals("mu/J5jGsroQM3Tbn4c6StBJG4C4glbTi8gT4jhRHSt0=", obj.entry().get(0).changes().get(0).value().messages().get(0).document().sha256());
        Assertions.assertEquals("848704520347750", obj.entry().get(0).changes().get(0).value().messages().get(0).document().id());
        Assertions.assertEquals("4_641947.pdf", obj.entry().get(0).changes().get(0).value().messages().get(0).document().filename());

    }

    @Test
    void testDeserializationContactMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "contactMessage.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673641462", obj.entry().get(0).changes().get(0).value().messages().get(0).timestamp());
        Assertions.assertEquals(MessageType.CONTACTS, obj.entry().get(0).changes().get(0).value().messages().get(0).type());

        Assertions.assertEquals("Person", obj.entry().get(0).changes().get(0).value().messages().get(0).contacts().get(0).name().firstName());

    }

    @Test
    void testDeserializationLocationMessage() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "locationMessage.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals("1673641462", obj.entry().get(0).changes().get(0).value().messages().get(0).timestamp());
        Assertions.assertEquals(MessageType.LOCATION, obj.entry().get(0).changes().get(0).value().messages().get(0).type());

        Assertions.assertEquals(-10.93941311633, obj.entry().get(0).changes().get(0).value().messages().get(0).location().latitude());
        Assertions.assertEquals(-10.606395436721, obj.entry().get(0).changes().get(0).value().messages().get(0).location().longitude());
        Assertions.assertEquals("https://foursquare.com/v/5c42c5667d8497002c6e09f9", obj.entry().get(0).changes().get(0).value().messages().get(0).location().url());

    }

    @Test
    void testDeserializationVerifiedAccount() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "verifiedAccount.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(EventType.VERIFIED_ACCOUNT, obj.entry().get(0).changes().get(0).value().event());
        Assertions.assertEquals(FieldType.ACCOUNT_UPDATE, obj.entry().get(0).changes().get(0).field());


    }

    @Test
    void testDeserializationRejectedTemplate() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "rejectedTemplate.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(EventType.REJECTED, obj.entry().get(0).changes().get(0).value().event());
        Assertions.assertEquals("905507062668800", obj.entry().get(0).changes().get(0).value().messageTemplateId());
        Assertions.assertEquals(FieldType.MESSAGE_TEMPLATE_STATUS_UPDATE, obj.entry().get(0).changes().get(0).field());

    }

    @Test
    void testDeserializationPhoneNumberNameUpdate() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "phoneNumberNameUpdate.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.PHONE_NUMBER_NAME_UPDATE, obj.entry().get(0).changes().get(0).field());

        Assertions.assertEquals("APPROVED", obj.entry().get(0).changes().get(0).value().decision());
        Assertions.assertEquals("WhatsApp", obj.entry().get(0).changes().get(0).value().requestedVerifiedName());

    }

    @Test
    void testDeserializationTemplateSchedulingForDisabling() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "templateSchedulingForDisabling.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.MESSAGE_TEMPLATE_STATUS_UPDATE, obj.entry().get(0).changes().get(0).field());

        Assertions.assertEquals(EventType.FLAGGED, obj.entry().get(0).changes().get(0).value().event());
        Assertions.assertEquals("My message template", obj.entry().get(0).changes().get(0).value().messageTemplateName());


    }

    @Test
    void testDeserializationQualityUpdate() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "qualityUpdate.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.PHONE_NUMBER_QUALITY_UPDATE, obj.entry().get(0).changes().get(0).field());


    }

    @Test
    void testDeserializationAccountBanned() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "accountBanned.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.ACCOUNT_UPDATE, obj.entry().get(0).changes().get(0).field());
        Assertions.assertNotNull(obj.entry().get(0).changes().get(0).value().banInfo());
    }

    @Test
    void testDeserializationAccountReview() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "accountReview.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.ACCOUNT_REVIEW_UPDATE, obj.entry().get(0).changes().get(0).field());
    }

    @Test
    void testDeserializationAccountRestricted() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "accountRestricted.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.ACCOUNT_UPDATE, obj.entry().get(0).changes().get(0).field());
        Assertions.assertEquals(RestrictionType.RESTRICTED_ADD_PHONE_NUMBER_ACTION, obj.entry().get(0).changes().get(0).value().restrictionInfo().get(0).restrictionType());
    }

    @Test
    void testDeserializationMediaUploadError() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "mediaUploadError.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.MESSAGES, obj.entry().get(0).changes().get(0).field());

        var statuses = obj.entry().get(0).changes().get(0).value().statuses();

        Assertions.assertNotNull(statuses);

        Assertions.assertEquals(131053, statuses.get(0).errors().get(0).code());
        Assertions.assertEquals("Media upload error", statuses.get(0).errors().get(0).title());
        Assertions.assertEquals("Media upload error", statuses.get(0).errors().get(0).message());
        Assertions.assertEquals("Unsupported Video mime type text/html. Please use one of video/3gpp, video/mp4.", statuses.get(0).errors().get(0).errorData().details());
    }

    @Test
    void testDeserializationReEngagementMessageError() throws IOException, URISyntaxException {
        var payload = fromResource(JSON_FOLDER + "reEngagementMessageError.json");

        var obj = WebHook.constructEvent(payload);

        Assertions.assertEquals(FieldType.MESSAGES, obj.entry().get(0).changes().get(0).field());

        var statuses = obj.entry().get(0).changes().get(0).value().statuses();

        Assertions.assertNotNull(statuses);

        Assertions.assertEquals(MessageStatus.FAILED, statuses.get(0).status());
        Assertions.assertEquals(131047, statuses.get(0).errors().get(0).code());
        Assertions.assertEquals("Re-engagement message", statuses.get(0).errors().get(0).title());
        Assertions.assertEquals("Re-engagement message", statuses.get(0).errors().get(0).message());
        Assertions.assertEquals("https://developers.facebook.com/docs/whatsapp/cloud-api/support/error-codes/", statuses.get(0).errors().get(0).href());
        Assertions.assertEquals("Message failed to send because more than 24 hours have passed since the customer last replied to this number.", statuses.get(0).errors().get(0).errorData().details());

    }
}

