package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>An object with the body of the message.</p>
 * <br>
 * <p> The body object contains the following field: </p>
 * <ul>
 *     <li><b>text: </b><i>Required if body is present</i> - The content of the message. Emojis and markdown are supported. Maximum length: 1024 characters</li>
 * </ul>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Body {

    /**
     * The Text.
     */
    @JsonProperty("text")
    public String text;

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
    public Body setText(String text) {
        this.text = text;
        return this;
    }
}
