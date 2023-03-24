package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Button payload parameter.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#button-parameter-object">Api reference</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ButtonPayloadParameter extends Parameter {
    @JsonProperty("payload")
    private String payload;


    /**
     * Instantiates a new Button payload parameter.
     */
    public ButtonPayloadParameter() {
        super(ParameterType.PAYLOAD);
    }

    /**
     * Instantiates a new Button payload parameter.
     *
     * @param payload the payload - Required for quick_reply buttons.
     *                Developer-defined payload that is returned when the button is clicked in addition to the display text on the button.
     */
    public ButtonPayloadParameter(String payload) {
        super(ParameterType.PAYLOAD);
        this.payload = payload;
    }

    /**
     * Gets payload.
     *
     * @return the payload
     */
    public String getPayload() {
        return payload;
    }

    /**
     * Sets payload. Required for quick_reply buttons.
     * Developer-defined payload that is returned when the button is clicked in addition to the display text on the button.
     *
     * @param payload the payload
     * @return the payload
     */
    public ButtonPayloadParameter setPayload(String payload) {
        this.payload = payload;
        return this;
    }
}
