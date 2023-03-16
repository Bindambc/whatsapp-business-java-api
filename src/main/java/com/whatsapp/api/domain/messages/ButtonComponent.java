package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.messages.type.ComponentType;

/**
 * The type Button component.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ButtonComponent extends Component<ButtonComponent> {
    @JsonProperty("index")
    private int index;
    @JsonProperty("sub_type")
    private ButtonSubType subType;


    /**
     * Instantiates a new Button component.
     */
    public ButtonComponent() {
        super(ComponentType.BUTTON);
    }

    /**
     * Instantiates a new Button component.
     *
     * @param index   the index
     * @param subType the sub type
     */
    public ButtonComponent(int index, ButtonSubType subType) {
        super(ComponentType.BUTTON);
        this.index = index;
        this.subType = subType;
    }

    /**
     * Gets index.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets index. Required when type=button. Not used for the other types. Only used for Cloud API.
     * Position index of the button. You can have up to 3 buttons using index values of 0 to 2.
     *
     * @param index the index
     * @return the index
     */
    public ButtonComponent setIndex(int index) {
        this.index = index;
        return this;
    }

    /**
     * Gets sub type.
     *
     * @return the sub type
     */
    public ButtonSubType getSubType() {
        return subType;
    }

    /**
     * Sets sub type. Required when type=button. Not used for the other types.
     * Type of button to create.
     *
     * @param subType the sub type
     * @return the sub type
     */
    public ButtonComponent setSubType(ButtonSubType subType) {
        this.subType = subType;
        return this;
    }
}
