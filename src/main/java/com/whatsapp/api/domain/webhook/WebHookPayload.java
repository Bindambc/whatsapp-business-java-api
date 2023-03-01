package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @deprecated use {@link WebHookEvent} instead
 **/
@Deprecated(forRemoval = true)
public record WebHookPayload(

        @JsonProperty("entry") List<Entry> entry,

        @JsonProperty("object") String object) {
}