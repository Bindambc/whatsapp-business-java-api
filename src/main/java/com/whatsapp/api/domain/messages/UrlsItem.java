package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UrlsItem {

    @JsonProperty("type")
    private String type;

    @JsonProperty("url")
    private String url;

    public String getType() {
        return type;
    }

    public UrlsItem setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public UrlsItem setUrl(String url) {
        this.url = url;
        return this;
    }
}