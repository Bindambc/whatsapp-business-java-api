package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.HeaderType;

/**
 * <p>Header content displayed on top of a message. You cannot set a header if your interactive object is of product type</p>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Header {

    /**
     * The Type.
     */
    @JsonProperty("type")
    private HeaderType type;
    /**
     * The Text.
     */
    @JsonProperty("text")
    private String text;

    /**
     * <b>Required</b> if type is set to document.
     * Contains the media object for this document.
     */
    @JsonProperty("document")
    private Document document;

    /**
     * <b>Required</b> if type is set to image.
     * Contains the media object for this image.
     */
    @JsonProperty("image")
    private Image image;

    /**
     * <b>Required</b> if type is set to video.
     * Contains the media object for this video.
     */
    @JsonProperty("video")
    private Video video;


    /**
     * Instantiates a new Header.
     *
     * @param type <b>Allways Required</b>. The header type you would like to use
     */
    public Header(HeaderType type) {
        this.type = type;
    }


    /**
     * Instantiates a new Header.
     */
    public Header() {
    }

    /**
     * Gets type.
     *
     * @return the Header
     */
    public HeaderType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type <b>Required</b>. The header type you would like to us
     * @return the Header
     */
    public Header setType(HeaderType type) {
        this.type = type;
        return this;
    }

    /**
     * Gets text.
     *
     * @return the Header
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text <b>Required</b> if type is set to text. Text for the header.
     *             <br>Formatting allows emojis, but not markdown.
     *             <br>Maximum length is 60 characters.
     * @return the Header
     */
    public Header setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * Gets document.
     *
     * @return the Header
     */
    public Document getDocument() {
        return document;
    }

    /**
     * Sets document.
     *
     * @param document <b>Required</b> if type is set to document.
     *                 <br>Contains the media object for this document.
     * @return the Header
     */
    public Header setDocument(Document document) {
        this.document = document;
        return this;
    }

    /**
     * Gets image.
     *
     * @return the Header
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image <b>Required</b> if type is set to image.
     *              <br>Contains the media object for this image.
     * @return the Header
     */
    public Header setImage(Image image) {
        this.image = image;
        return this;
    }

    /**
     * Gets video.
     *
     * @return the Header
     */
    public Video getVideo() {
        return video;
    }

    /**
     * Sets video.
     *
     * @param video <b>Required</b> if type is set to video.
     *              <br>Contains the media object for this video.
     * @return the Header
     */
    public Header setVideo(Video video) {
        this.video = video;
        return this;
    }
}
