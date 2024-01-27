package com.whatsapp.api.domain.webhook.type;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum WebhookType {
    whatsapp_business_account,
    @JsonEnumDefaultValue
    unknown
}