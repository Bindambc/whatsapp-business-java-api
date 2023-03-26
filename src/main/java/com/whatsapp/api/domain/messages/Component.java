package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.whatsapp.api.domain.messages.type.ComponentType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Component.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = ButtonComponent.class, name = "button"), //
        @JsonSubTypes.Type(value = HeaderComponent.class, name = "header"), //
        @JsonSubTypes.Type(value = BodyComponent.class, name = "body")})//
public abstract class Component<T extends Component<T>> {
    @JsonProperty("type")
    private final ComponentType type;
    @JsonProperty("parameters")
    private List<Parameter> parameters;


    /**
     * Instantiates a new Component.
     *
     * @param type the type
     */
    @JsonCreator
    protected Component(ComponentType type) {
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
    public Component<T> setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Add parameter component.
     *
     * @param parameter the parameter
     * @return the component
     */
    public Component<T> addParameter(Parameter parameter) {
        if (this.parameters == null) this.parameters = new ArrayList<>();

        this.parameters.add(parameter);

        return this;
    }
}