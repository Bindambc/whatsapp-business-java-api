
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Button {

    @JsonProperty("type")
    public String type;
    @JsonProperty("reply")
    public Reply reply;

    public String getType() {
        return type;
    }

    public Button setType(String type) {
        this.type = type;
        return this;
    }

    public Reply getReply() {
        return reply;
    }

    public Button setReply(Reply reply) {
        this.reply = reply;
        return this;
    }
}
