package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Video parameter.
 */
public class VideoParameter extends Parameter {

    @JsonProperty("id")
    private String id;
    @JsonProperty("link")
    private String link;

    /**
     * Instantiates a new Parameter.
     */
    protected VideoParameter() {
        super(ParameterType.VIDEO);
    }

    /**
     * Instantiates a new Video parameter.
     *
     * @param id   the id
     * @param link the link
     */
    public VideoParameter(String id, String link) {
        super(ParameterType.VIDEO);
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
    public VideoParameter setId(String id) {
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
    public VideoParameter setLink(String link) {
        this.link = link;
        return this;
    }
}
