package com.whatsapp.api.domain.messages;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parameter {

    private final ParameterType type;

    protected Parameter(ParameterType type) {
        this.type = type;
    }

    public ParameterType getType() {
        return type;
    }
}
