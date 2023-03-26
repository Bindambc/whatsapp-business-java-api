package com.whatsapp.api.domain.messages;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parameter {
    @JsonProperty("type")
    private final ParameterType type;

    /**
     * Instantiates a new Parameter.
     *
     * @param type the type
     */
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
