package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>An object with the footer of the message</p>
 * <br>
 * <p>The footer object contains the following field:</p>
 * <ul>
 *     <li><b>text: </b><i>Required if footer is present</i> - The footer content. Emojis, markdown, and links are supported. Maximum length: 60 characters</li>
 * </ul>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Footer {

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
    public Footer setText(String text) {
        this.text = text;
        return this;
    }
}
