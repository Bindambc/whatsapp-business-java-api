package com.whatsapp.api.domain.templates.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Message template id response.
 *
 * @deprecated use {@link com.whatsapp.api.domain.templates.MessageTemplate} instead
 */
@Deprecated(forRemoval = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MessageTemplateIDResponse(@JsonProperty("id") String id) {
}
