package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ButtonComponent extends Component<ButtonComponent> {


    private List<Button> buttons;


    public ButtonComponent() {
        super(ComponentType.BUTTONS);
    }


    public List<Button> getButtons() {
        return buttons;
    }

    public ButtonComponent setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    public ButtonComponent addButton(Button button) {
        if (this.buttons == null) this.buttons = new ArrayList<>();
        this.buttons.add(button);
        return this;
    }
}
