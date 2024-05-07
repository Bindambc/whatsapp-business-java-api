package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.FieldType;

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE;

/**
 * Changes that triggered the Webhooks call.
 *
 * @param field A value object. Contains details of the changes related to the specified field.
 * @param value Contains the type of notification you are getting on that Webhook. Currently, the only option for this API is “messages”.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(with = READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)
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