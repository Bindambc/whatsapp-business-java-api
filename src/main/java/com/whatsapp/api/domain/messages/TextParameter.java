package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextParameter extends Parameter {

    private final String text;


    public TextParameter(String text) {
        super(ParameterType.TEXT);
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
