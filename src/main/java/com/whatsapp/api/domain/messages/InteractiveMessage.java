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

    /**
     * The Action.
     */
    @JsonProperty("action")
    public Action action;
    /**
     * The Type.
     */
    @JsonProperty("type")
    public InteractiveMessageType type;
    /**
     * The Header.
     */
    @JsonProperty("header")
    public Header header;
    /**
     * The Body.
     */
    @JsonProperty("body")
    public Body body;
    /**
     * The Footer.
     */
    @JsonProperty("footer")
    public Footer footer;

    private InteractiveMessage() {
    }

    /**
     * Build interactive action.
     *
     * @return the interactive action
     */
    public static IInteractiveAction build() {
        return new InteractiveMessage();
    }

    /**
     * Gets action.
     *
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    public IInteractiveType setAction(Action action) {
        this.action = action;
        return this;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public InteractiveMessageType getType() {
        return type;
    }

    public InteractiveMessage setType(InteractiveMessageType type) {
        this.type = type;
        return this;
    }

    /**
     * Gets header.
     *
     * @return the header
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets header.
     *
     * @param header the header
     * @return the header
     */
    public InteractiveMessage setHeader(Header header) {
        this.header = header;
        return this;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public Body getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     * @return the body
     */
    public InteractiveMessage setBody(Body body) {
        this.body = body;
        return this;
    }

    /**
     * Gets footer.
     *
     * @return the footer
     */
    public Footer getFooter() {
        return footer;
    }

    /**
     * Sets footer.
     *
     * @param footer the footer
     * @return the footer
     */
    public InteractiveMessage setFooter(Footer footer) {
        this.footer = footer;
        return this;
    }
}
