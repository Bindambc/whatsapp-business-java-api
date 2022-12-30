package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * The parts of the message template.
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
    private  ComponentType type;

    private String text;

    private Example example;
    protected Component(){

    }

    protected Component(ComponentType type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public T setText(String text) {
        this.text = text;
        return (T) this;
    }

    public String getText() {
        return text;
    }

    public Example getExample() {
        return example;
    }

    @SuppressWarnings("unchecked")
    public T setExample(Example example) {
        this.example = example;
        return (T) this;
    }

    public Component<T> setType(ComponentType type) {
        this.type = type;
        return this;
    }

    public ComponentType getType() {
        return type;
    }
}
