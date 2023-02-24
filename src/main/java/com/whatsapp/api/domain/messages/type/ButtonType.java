package com.whatsapp.api.domain.messages.type;
//TODO: implementar mais tipos de mensagens. Não está completo.

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <ul>
 *  <li>reply: for Reply Button</li>
 * </ul>
 */
public enum ButtonType {
    REPLY("reply");
    private final String value;

    ButtonType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
