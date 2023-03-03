package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.type.ComponentType;
import com.whatsapp.api.domain.templates.type.HeaderFormat;

/**
 * Header component
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeaderComponent extends Component<HeaderComponent> {
    /**
     * Only applies to the HEADER type.
     * Values: TEXT, IMAGE, DOCUMENT, VIDEO
     */
    private HeaderFormat format;

    /**
     * Instantiates a new Header component.
     */
    public HeaderComponent() {
        super(ComponentType.HEADER);
    }


    /**
     * Gets format.
     *
     * @return the format
     */
    public HeaderFormat getFormat() {
        return format;
    }

    /**
     * Sets format.
     *
     * @param format the format
     * @return the format
     */
    public HeaderComponent setFormat(HeaderFormat format) {
        this.format = format;
        return this;
    }


}
