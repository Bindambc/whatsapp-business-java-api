package com.whatsapp.api.domain.messages.type;
//TODO: implementar mais tipos de mensagens. Não está completo.

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Mandatory for message templates.
 * <p>
 * The type of message being sent.
 * Options:
 * <ul>
 * <li>text: for text messages.</li>
 * <li>template: for template messages. Only text-based templates are supported.</li>
 * <li>document: for document messages.</li>
 * <li>image: for image messages.</li>
 * <li>interactive: for list and reply button messages.</li>
 * <li>audio: for audio messages.</li>
 * <li>contacts: for contacts messages.</li>
 * <li>location: for location messages.</li>
 * <li>sticker: for sticker messages.</li>
 * <li>video: for video messages.</li>
 * </ul>
 */
public enum MessageType {
    AUDIO("audio"), //
    BUTTON("button"),//
    CONTACTS("contacts"),//
    DOCUMENT("document"), //
    LOCATION("location"), //

    TEXT("text"), //
    TEMPLATE("template"), //
    IMAGE("image"), //
    INTERACTIVE("interactive"), //
    ORDER("order"), //
    REACTION("reaction"), //
    STICKER("sticker"), //
    SYSTEM("system"), //
    UNKNOWN("unknown"), //
    VIDEO("video"),//
    UNSUPPORTED("unsupported"),//

    @Deprecated(forRemoval = true) HSM("hsm");//

    private final String value;

    MessageType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
