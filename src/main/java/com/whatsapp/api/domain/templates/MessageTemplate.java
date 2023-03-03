package com.whatsapp.api.domain.templates;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.type.Category;
import com.whatsapp.api.domain.templates.type.LanguageType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>Wrapper to Message Temaplate.</b>
 * A message template is required for any business-initiated messages sent using the WhatsApp Business Platform.
 * These templates can be created using the Business Management API or the WhatsApp Business Manager.
 * <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates#">See more</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageTemplate {
    /**
     * The name of the message template.
     */
    private String name;
    /**
     * The language of the message template.
     */
    private LanguageType languageType;
    /**
     * The type of message template.
     */
    private Category category;
    /**
     * The parts of the message template.
     */
    private List<Component<?>> components;


    /**
     * Add component message template.
     *
     * @param component the component
     * @return the message template
     */
    public MessageTemplate addComponent(Component<?> component) {
        if (this.components == null) this.components = new ArrayList<>();

        this.components.add(component);
        return this;

    }

    /**
     * Add components message template.
     *
     * @param components the components
     * @return the message template
     */
    public MessageTemplate addComponents(Component<?>... components) {
        if (this.components == null) this.components = new ArrayList<>();
        if (components != null) this.components.addAll(Arrays.stream(components).toList());
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
    public MessageTemplate setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public LanguageType getLanguage() {
        return languageType;
    }

    /**
     * Sets language.
     *
     * @param languageType the language
     * @return the language
     */
    public MessageTemplate setLanguage(LanguageType languageType) {
        this.languageType = languageType;
        return this;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     * @return the category
     */
    public MessageTemplate setCategory(Category category) {
        this.category = category;
        return this;
    }

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
    public MessageTemplate setComponents(List<Component<?>> components) {
        this.components = components;
        return this;
    }
}
