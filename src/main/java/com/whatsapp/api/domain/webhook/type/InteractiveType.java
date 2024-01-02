package com.whatsapp.api.domain.webhook.type;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum InteractiveType {
    button_reply, list_reply,
    @JsonEnumDefaultValue
    unknown
}