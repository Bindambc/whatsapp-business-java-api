
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.builder.IInteractiveMessageBuilder.IInteractiveAction;
import com.whatsapp.api.domain.messages.builder.IInteractiveMessageBuilder.IInteractiveType;
import com.whatsapp.api.domain.messages.type.InteractiveMessageType;

/**
 * <p>Interactive messages give your users a simpler way to find and select what they want from your business on WhatsApp</p>
 * <br>
 * <ul>
 *     <li><b>action:</b> <i>Required</i> - Action you want the user to perform after reading the message</li>
 *     <li><b>body:</b> <i>Optional for type product. Required for other message types</i> - An object with the body of the message</li>
 *     <li><b>footer:</b> <i>Optional</i> - An object with the footer of the message</li>
 *     <li><b>header:</b> <i>Required for type product_list. Optional for other types</i> - Header content displayed on top of a message.
 *     You cannot set a header if your interactive object is of product type</li>
 *     <li><b>type:</b> <i>Required</i> - The type of interactive message you want to send</li>
 * </ul>
 */
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
