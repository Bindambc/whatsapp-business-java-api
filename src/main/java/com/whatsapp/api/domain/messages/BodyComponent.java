package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.messages.type.ComponentType;


/**
 * The type Body component, to send template messages
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BodyComponent extends Component<BodyComponent> {


    /**
     * Instantiates a new Body component, to send template messages
     */
    public BodyComponent() {
        super(ComponentType.BODY);
    }


}
