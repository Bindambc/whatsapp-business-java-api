package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.whatsapp.api.domain.templates.type.ComponentType;

/**
 * The parts of the message template.
 *
 * @param <T> the type parameter
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = ButtonComponent.class, name = "BUTTONS"),
        @JsonSubTypes.Type(value = FooterComponent.class, name = "FOOTER"),
        @JsonSubTypes.Type(value = HeaderComponent.class, name = "HEADER"),
        @JsonSubTypes.Type(value = BodyComponent.class, name = "BODY")
})
public class Component<T extends Component<T>> {
    /**
     * <b>Required.</b>
     *
     * <ul>Values:
     * <li>BODY</li>
     * <li>HEADER</li>
     * <li>FOOTER</li>
     * <li>BUTTONS</li>
     * </ul>
     */
    private com.whatsapp.api.domain.templates.type.ComponentType type;

    private String text;

    private Example example;

    /**
     * Instantiates a new Component.
     */
    protected Component() {

    }

    /**
     * Instantiates a new Component.
     *
     * @param type the type
     */
    protected Component(com.whatsapp.api.domain.templates.type.ComponentType type) {
        this.type = type;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     * @return the text
     */
    @SuppressWarnings("unchecked")
    public T setText(String text) {
        this.text = text;
        return (T) this;
    }

    /**
     * Gets example.
     *
     * @return the example
     */
    public Example getExample() {
        return example;
    }

    /**
     * Sets example.
     *
     * @param example the example
     * @return the example
     */
    @SuppressWarnings("unchecked")
    public T setExample(Example example) {
        this.example = example;
        return (T) this;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public com.whatsapp.api.domain.templates.type.ComponentType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     * @return the type
     */
    public Component<T> setType(ComponentType type) {
        this.type = type;
        return this;
    }
}
