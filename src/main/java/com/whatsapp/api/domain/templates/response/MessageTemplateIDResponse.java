package com.whatsapp.api.domain.templates.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Message template id response.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MessageTemplateIDResponse(@JsonProperty("id") String id) {
}
