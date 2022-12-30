package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.ComponentType;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Component {
    private final ComponentType type;
    private List<Parameter> parameters;

    public Component(ComponentType type) {
        this.type = type;
    }

    public ComponentType getType() {
        return type;
    }


    public List<Parameter> getParameters() {
        return parameters;
    }

    public Component setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    public Component addParameter(Parameter parameter) {
        if (this.parameters == null) this.parameters = new ArrayList<>();

        this.parameters.add(parameter);

        return this;
    }
}