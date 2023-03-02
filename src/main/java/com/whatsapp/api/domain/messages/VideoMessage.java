package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Video message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoMessage extends MediaMessage<VideoMessage> {

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
     * @param caption <b>Optional</b>. Describes the specified image, document, or video media. Do not use with audio or sticker media.
     * @return the caption
     */
    public VideoMessage setCaption(String caption) {
        this.caption = caption;
        return this;
    }
}
