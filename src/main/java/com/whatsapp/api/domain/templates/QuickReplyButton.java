package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuickReplyButton extends Button {
    protected QuickReplyButton() {

    }

    public QuickReplyButton(String text) {
        super(ButtonType.QUICK_REPLY, text);
    }


}
