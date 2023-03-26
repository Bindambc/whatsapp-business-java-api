package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Video.
 */
@JsonInclude(Include.NON_NULL)
public class Video {

    @JsonProperty("id")
    private String id;
    @JsonProperty("link")
    private String link;

    /**
     * Instantiates a new Video.
     */
    public Video() {
    }

    /**
     * Instantiates a new Video.
     *
     * @param id   the id
     * @param link the link
     */
    public Video(String id, String link) {
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
    public Video setId(String id) {
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
    public Video setLink(String link) {
        this.link = link;
        return this;
    }
}
