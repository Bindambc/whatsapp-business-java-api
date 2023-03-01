package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class is a representation of the json object sent by the WhatsApp webhook.
 * Whenever a trigger event occurs, the WhatsApp Business Platform sees the event and sends a notification to a Webhook URL you have previously specified.
 * You can get two types of notifications:<br>
 * - <b>Received messages</b>: This alert lets you know when you have received a message. These can also be called "inbound notifications" throughout the documentation.<br>
 * - <b>Message status and pricing notifications</b>: This alert lets you know when the status of a message has changed —for example, the message has been read or delivered. These can also be called "outbound notifications" throughout the documentation.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/set-up-webhooks">Webhooks Setup Guide</a> to more details.
 **/
public record WebHookEvent(@JsonProperty("entry") List<Entry> entry, @JsonProperty("object") String object) {
}
