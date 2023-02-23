
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Footer {

    @JsonProperty("text")
    public String text;

    public String getText() {
        return text;
    }

    public Footer setText(String text) {
        this.text = text;
        return this;
    }
}
