package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = PhoneNumberButton.class, name = "PHONE_NUMBER"),//
        @JsonSubTypes.Type(value = UrlButton.class, name = "URL"), //
        @JsonSubTypes.Type(value = QuickReplyButton.class, name = "QUICK_REPLY")})
public class Button {

    private ButtonType type;
    private String text;

    protected Button() {

    }

    protected Button(ButtonType type, String text) {
        this.type = type;
        this.text = text;
    }

    public Button(ButtonType buttonType) {
        this.type = buttonType;
    }

    public ButtonType getType() {
        return type;
    }

    public Button setType(ButtonType type) {
        this.type = type;
        return this;
    }

    public String getText() {
        return text;
    }

    public Button setText(String text) {
        this.text = text;
        return this;
    }
}
