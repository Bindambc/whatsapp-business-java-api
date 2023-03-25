package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Document.
 */
@JsonInclude(Include.NON_NULL)
public class Document {

    @JsonProperty("id")
    private String id;
    @JsonProperty("link")
    private String link;

    @JsonProperty("filename")
    private String fileName;

    /**
     * Instantiates a new Document.
     *
     * @param id       the id
     * @param link     the link
     * @param fileName the file name
     */
    public Document(String id, String link, String fileName) {
        this.id = id;
        this.link = link;
        this.fileName = fileName;
    }

    /**
     * Instantiates a new Document.
     */
    public Document() {
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
    public Document setId(String id) {
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
    public Document setLink(String link) {
        this.link = link;
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
     * @param fileName the file name
     * @return the file name
     */
    public Document setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
