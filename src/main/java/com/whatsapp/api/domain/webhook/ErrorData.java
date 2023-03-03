package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorData(

	@JsonProperty("details")
	String details
) {
}