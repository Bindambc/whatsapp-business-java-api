package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Image.
 */
@JsonInclude(Include.NON_NULL)
public class Image {

    @JsonProperty("id")
    private String id;

    @JsonProperty("link")
    private String link;

    /**
     * Instantiates a new Image.
     */
    public Image() {
    }

    /**
     * Instantiates a new Image.
     *
     * @param id   the image id
     * @param link the image link
     */
    public Image(String id, String link) {
        this.id = id;
        this.link = link;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     * @return the id
     */
    public Image setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Gets link.
     *
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets link.
     *
     * @param link the link
     * @return the link
     */
    public Image setLink(String link) {
        this.link = link;
        return this;
    }
}
