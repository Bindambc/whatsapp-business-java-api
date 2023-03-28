package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.type.ComponentType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Button component.
 */
//TODO: review
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ButtonComponent extends Component<ButtonComponent> {


    private List<Button> buttons;


    /**
     * Instantiates a new Button component.
     */
    public ButtonComponent() {
        super(ComponentType.BUTTONS);
    }


    /**
     * Gets buttons.
     *
     * @return the buttons
     */
    public List<Button> getButtons() {
        return buttons;
    }

    /**
     * Sets buttons.
     *
     * @param buttons the buttons
     * @return the buttons
     */
    public ButtonComponent setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    /**
     * Add button button component.
     *
     * @param button the button
     * @return the button component
     */
    public ButtonComponent addButton(Button button) {
        if (this.buttons == null) this.buttons = new ArrayList<>();
        this.buttons.add(button);
        return this;
    }
}
