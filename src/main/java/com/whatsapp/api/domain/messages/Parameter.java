package com.whatsapp.api.domain.messages;


import com.fasterxml.jackson.annotation.*;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Parameter.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = TextParameter.class, name = "text"),
        @JsonSubTypes.Type(value = CurrencyParameter.class, name = "currency"),
        @JsonSubTypes.Type(value = DateTimeParameter.class, name = "date_time"),
        @JsonSubTypes.Type(value = ImageParameter.class, name = "image"),
        @JsonSubTypes.Type(value = VideoParameter.class, name = "video"),
        @JsonSubTypes.Type(value = DocumentParameter.class, name = "document"),
        @JsonSubTypes.Type(value = ButtonPayloadParameter.class, name = "payload")})
public class Parameter {
    @JsonProperty("type")
    private final ParameterType type;

    /**
     * Instantiates a new Parameter.
     *
     * @param type the type
     */
    @JsonCreator
    protected Parameter(ParameterType type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public ParameterType getType() {
        return type;
    }
}
