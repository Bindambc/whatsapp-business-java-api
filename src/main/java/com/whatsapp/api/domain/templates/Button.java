package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.whatsapp.api.domain.templates.type.ButtonType;

/**
 * The type Button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = PhoneNumberButton.class, name = "PHONE_NUMBER"),//
        @JsonSubTypes.Type(value = UrlButton.class, name = "URL"), //
        @JsonSubTypes.Type(value = QuickReplyButton.class, name = "QUICK_REPLY")})
public class Button {

    private ButtonType type;
    private String text;

    /**
     * Instantiates a new Button.
     */
    protected Button() {

    }

    /**
     * Instantiates a new Button.
     *
     * @param type the type
     * @param text the text
     */
    protected Button(ButtonType type, String text) {
        this.type = type;
        this.text = text;
    }

    /**
     * Instantiates a new Button.
     *
     * @param buttonType the button type
     */
    public Button(ButtonType buttonType) {
        this.type = buttonType;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public ButtonType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     * @return the type
     */
    public Button setType(ButtonType type) {
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
    public Button setText(String text) {
        this.text = text;
        return this;
    }
}
