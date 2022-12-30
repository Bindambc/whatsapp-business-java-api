package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;

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

    public HeaderComponent() {
        super(ComponentType.HEADER);
    }

    
    public HeaderFormat getFormat() {
        return format;
    }

    public HeaderComponent setFormat(HeaderFormat format) {
        this.format = format;
        return this;
    }


}
