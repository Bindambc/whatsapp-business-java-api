package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Template message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemplateMessage {
    @JsonProperty("components")
    private List<Component<?>> components;
    @JsonProperty("name")
    private String name;
    @JsonProperty("language")
    private Language language;

    /**
     * Gets components.
     *
     * @return the components
     */
    public List<Component<?>> getComponents() {
        return components;
    }

    /**
     * Sets components.
     *
     * @param components the components
     * @return the components
     */
    public TemplateMessage setComponents(List<Component<?>> components) {
        this.components = components;
        return this;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @return the name
     */
    public TemplateMessage setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Sets language.
     *
     * @param language the language
     * @return the language
     */
    public TemplateMessage setLanguage(Language language) {
        this.language = language;
        return this;
    }


    /**
     * Add component template message.
     *
     * @param component the component
     * @return the template message
     */
    public TemplateMessage addComponent(Component<?> component) {
        if (this.components == null) this.components = new ArrayList<>();

        this.components.add(component);
        return this;

    }


}