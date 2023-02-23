
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Header {

    @JsonProperty("type")
    public String type;
    @JsonProperty("text")
    public String text;

    public String getType() {
        return type;
    }

    public Header setType(String type) {
        this.type = type;
        return this;
    }

    public String getText() {
        return text;
    }

    public Header setText(String text) {
        this.text = text;
        return this;
    }
}
