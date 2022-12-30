package com.whatsapp.api.domain.templates;


import com.fasterxml.jackson.annotation.JsonInclude;

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
    private Language language;
    /**
     * The type of message template.
     */
    private Category category;
    /**
     * The parts of the message template.
     */
    private List<Component<?>> components;


    public MessageTemplate addComponent(Component<?> component) {
        if (this.components == null) this.components = new ArrayList<>();

        this.components.add(component);
        return this;

    }

    public MessageTemplate addComponents(Component<?>... components) {
        if (this.components == null) this.components = new ArrayList<>();
        if (components != null) this.components.addAll(Arrays.stream(components).toList());
        return this;

    }


    public String getName() {
        return name;
    }

    public MessageTemplate setName(String name) {
        this.name = name;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public MessageTemplate setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public MessageTemplate setCategory(Category category) {
        this.category = category;
        return this;
    }

    public List<Component<?>> getComponents() {
        return components;
    }

    public MessageTemplate setComponents(List<Component<?>> components) {
        this.components = components;
        return this;
    }
}
