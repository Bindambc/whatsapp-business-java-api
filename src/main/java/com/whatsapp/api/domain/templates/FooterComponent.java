package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The type Footer component.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FooterComponent extends Component<FooterComponent> {


    /**
     * Instantiates a new Footer component.
     */
    public FooterComponent() {
        super(ComponentType.FOOTER);
    }


}
