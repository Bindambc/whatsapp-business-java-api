package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.type.ComponentType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Component.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Component {
    private final ComponentType type;
    private List<Parameter> parameters;

    /**
     * Instantiates a new Component.
     *
     * @param type the type
     */
    public Component(ComponentType type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public ComponentType getType() {
        return type;
    }


    /**
     * Gets parameters.
     *
     * @return the parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Sets parameters.
     *
     * @param parameters the parameters
     * @return the parameters
     */
    public Component setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Add parameter component.
     *
     * @param parameter the parameter
     * @return the component
     */
    public Component addParameter(Parameter parameter) {
        if (this.parameters == null) this.parameters = new ArrayList<>();

        this.parameters.add(parameter);

        return this;
    }
}