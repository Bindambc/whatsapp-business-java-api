package com.whatsapp.api.domain.messages.type;
//TODO: implementar mais tipos de mensagens. Não está completo.

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>The header type you would like to use</p>
 * <br>
 * <p>Supported values:</p>
 * <ul>
 *  <li><b>text:</b> Used for List Messages, Reply Buttons, and Multi-Product Messages</li>
 *  <li><b>video:</b> Used for Reply Buttons</li>
 *  <li><b>image:</b> Used for Reply Buttons</li>
 *  <li><b>document:</b> Used for Reply Buttons</li>
 * </ul>
 */
public enum HeaderType {
    TEXT("text"), /**/
    VIDEO("video"), /**/
    IMAGE("image"), /**/
    DOCUMENT("document"); /**/
    private final String value;

    HeaderType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
