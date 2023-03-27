package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.whatsapp.api.domain.messages.type.ComponentType;

@JsonInclude(Include.NON_NULL)

public class HeaderComponent extends Component<HeaderComponent> {
    /**
     * Instantiates a new Component.
     */
    public HeaderComponent() {
        super(ComponentType.HEADER);
    }


}
