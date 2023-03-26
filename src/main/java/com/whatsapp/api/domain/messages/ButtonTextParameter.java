package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Button text parameter.
 * Required for URL buttons.
 * Developer-provided suffix that is appended to the predefined prefix URL in the template.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#button-parameter-object">Api reference</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ButtonTextParameter extends Parameter {
    @JsonProperty("text")
    private String text;

    /**
     * Instantiates a new Button text parameter.
     */
    public ButtonTextParameter() {
        super(ParameterType.TEXT);
    }

    /**
     * Instantiates a new Button text parameter.
     *
     * @param text the text. <b>Required for URL buttons</b>. Developer-provided suffix that is appended to the predefined prefix URL in the template.
     */
    public ButtonTextParameter(String text) {
        super(ParameterType.TEXT);
        this.text = text;
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
     * @param text the text. <b>Required for URL buttons</b>. Developer-provided suffix that is appended to the predefined prefix URL in the template.
     * @return the text
     */
    public ButtonTextParameter setText(String text) {
        this.text = text;
        return this;
    }
}
