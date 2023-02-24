package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Row.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Row {

    /**
     * The Id.
     */
    @JsonProperty("id")
    public String id;
    /**
     * The Title.
     */
    @JsonProperty("title")
    public String title;
    /**
     * The Description.
     */
    @JsonProperty("description")
    public String description;

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
    public Row setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     * @return the title
     */
    public Row setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     * @return the description
     */
    public Row setDescription(String description) {
        this.description = description;
        return this;
    }
}
