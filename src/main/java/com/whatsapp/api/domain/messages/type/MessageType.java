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
    /**
     * Audio message type.
     */
    AUDIO("audio"), //
    /**
     * Button message type.
     */
    BUTTON("button"),//
    /**
     * Contacts message type.
     */
    CONTACTS("contacts"),//
    /**
     * Document message type.
     */
    DOCUMENT("document"), //
    /**
     * Location message type.
     */
    LOCATION("location"), //

    /**
     * Text message type.
     */
    TEXT("text"), //
    /**
     * Template message type.
     */
    TEMPLATE("template"), //
    /**
     * Image message type.
     */
    IMAGE("image"), //
    /**
     * Interactive message type.
     */
    INTERACTIVE("interactive"), //
    /**
     * Order message type.
     */
    ORDER("order"), //
    /**
     * Reaction message type.
     */
    REACTION("reaction"), //
    /**
     * Sticker message type.
     */
    STICKER("sticker"), //
    /**
     * System message type.
     */
    SYSTEM("system"), //
    /**
     * Unknown message type.
     */
    UNKNOWN("unknown"), //
    /**
     * Video message type.
     */
    VIDEO("video"),//
    /**
     * Unsupported message type.
     */
    UNSUPPORTED("unsupported"),//

    /**
     * Hsm message type.
     */
    @Deprecated(forRemoval = true) HSM("hsm");//

    private final String value;

    MessageType(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
