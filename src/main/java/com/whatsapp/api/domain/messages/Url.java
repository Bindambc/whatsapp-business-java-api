package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Url.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Url {

    @JsonProperty("type")
    private String type;

    @JsonProperty("url")
    private String url;

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     * @return the type
     */
    public Url setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     * @return the url
     */
    public Url setUrl(String url) {
        this.url = url;
        return this;
    }
}