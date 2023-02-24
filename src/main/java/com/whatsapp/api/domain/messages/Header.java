
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.HeaderType;

/**
 * <p>Header content displayed on top of a message. You cannot set a header if your interactive object is of product type</p>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Header {

    @JsonProperty("type")
    public HeaderType type;
    @JsonProperty("text")
    public String text;

    public HeaderType getType() {
        return type;
    }

    public Header setType(HeaderType type) {
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
