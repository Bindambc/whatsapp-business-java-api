package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Document message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentMessage extends MediaMessage<DocumentMessage> {
    @JsonProperty("caption")
    private String caption;

    @JsonProperty("filename")
    private String fileName;


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
     * @param caption <b>Optional</b>.  Describes the specified image, document, or video media. Do not use with audio or sticker media.
     * @return the caption
     */
    public DocumentMessage setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Gets file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets file name.
     *
     * @param fileName <b>Optional</b>. Describes the filename for the specific document. Use only with document media. The extension of the filename will specify what format the document is displayed as in WhatsApp.
     * @return the file name
     */
    public DocumentMessage setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
