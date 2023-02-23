
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.IInteractiveMessageBuilder.IInteractiveAction;
import com.whatsapp.api.domain.messages.IInteractiveMessageBuilder.IInteractiveType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InteractiveMessage implements IInteractiveAction, IInteractiveType {

    @JsonProperty("action")
    public Action action;
    @JsonProperty("type")
    public InteractiveMessageType type;
    @JsonProperty("header")
    public Header header;
    @JsonProperty("body")
    public Body body;
    @JsonProperty("footer")
    public Footer footer;

    private InteractiveMessage() {
    }

    public static IInteractiveAction build() {
        return new InteractiveMessage();
    }

    public Action getAction() {
        return action;
    }

    public IInteractiveType setAction(Action action) {
        this.action = action;
        return this;
    }

    public InteractiveMessageType getType() {
        return type;
    }

    public InteractiveMessage setType(InteractiveMessageType type) {
        this.type = type;
        return this;
    }

    public Header getHeader() {
        return header;
    }

    public InteractiveMessage setHeader(Header header) {
        this.header = header;
        return this;
    }

    public Body getBody() {
        return body;
    }

    public InteractiveMessage setBody(Body body) {
        this.body = body;
        return this;
    }

    public Footer getFooter() {
        return footer;
    }

    public InteractiveMessage setFooter(Footer footer) {
        this.footer = footer;
        return this;
    }
}
