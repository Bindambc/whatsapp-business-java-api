package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Document parameter.
 */
public class DocumentParameter extends Parameter {

    @JsonProperty("id")
    private String id;
    @JsonProperty("link")
    private String link;


    /**
     * Instantiates a new Document parameter.
     */
    public DocumentParameter() {
        super(ParameterType.DOCUMENT);
    }

    /**
     * Instantiates a new Document parameter.
     *
     * @param id   the id
     * @param link the link
     */
    public DocumentParameter(String id, String link) {
        super(ParameterType.DOCUMENT);
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
    public DocumentParameter setId(String id) {
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
    public DocumentParameter setLink(String link) {
        this.link = link;
        return this;
    }
}
