package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Image message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageMessage extends MediaMessage<ImageMessage> {
    @JsonProperty("caption")
    private String caption;


    /**
     * Gets caption.
     *
     * @return the caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Sets caption.
     *
     * @param caption Describes the specified image, document, or video media. Do not use with audio or sticker media.
     * @return the caption
     */
    public ImageMessage setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
