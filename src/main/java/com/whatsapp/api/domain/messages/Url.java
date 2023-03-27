package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.UrlType;

/**
 * Contact URL(s) formatted as a urls object
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Url {

    @JsonProperty("type")
    private UrlType type;

    @JsonProperty("url")
    private String url;

    /**
     * Gets type.
     *
     * @return the type
     */
    public UrlType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type. Standard values are HOME and WORK.
     * @return the type
     */
    public Url setType(UrlType type) {
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