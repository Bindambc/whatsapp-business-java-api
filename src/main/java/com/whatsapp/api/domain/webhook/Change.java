package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.FieldType;

/**
 * Changes that triggered the Webhooks call.
 *
 * @param field A value object. Contains details of the changes related to the specified field.
 * @param value Contains the type of notification you are getting on that Webhook. Currently, the only option for this API is “messages”.
 */
public record Change(
/*
Contains the type of notification you are getting on that Webhook. Currently, the only option for this API is “messages”.
 */
        @JsonProperty("field") FieldType field,
/*
A value object. Contains details of the changes related to the specified field.
 */
        @JsonProperty("value") Value value) {
}