package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BanInfo(@JsonProperty("waba_ban_state") String wabaBanState,

                      @JsonProperty("waba_ban_date") String wabaBanDate

) {
}
