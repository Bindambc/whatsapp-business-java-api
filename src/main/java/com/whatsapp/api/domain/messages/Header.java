package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.HeaderType;

/**
 * <p>Header content displayed on top of a message. You cannot set a header if your interactive object is of product type</p>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Header {

    /**
     * The Type.
     */
    @JsonProperty("type")
    public HeaderType type;
    /**
     * The Text.
     */
    @JsonProperty("text")
    public String text;

    /**
     * Gets type.
     *
     * @return the type
     */
    public HeaderType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     * @return the type
     */
    public Header setType(HeaderType type) {
        this.type = type;
        return this;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     * @return the text
     */
    public Header setText(String text) {
        this.text = text;
        return this;
    }
}
