package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.type.ButtonType;

import java.util.List;

/**
 * The type Url button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UrlButton extends Button {

    private String url;

    @JsonProperty("example")
    private List<String> urlExample;

    /**
     * Instantiates a new Url button.
     */
    protected UrlButton() {
        super(ButtonType.URL);
    }

    /**
     * Instantiates a new Url button.
     *
     * @param text the text
     */
    public UrlButton(String text) {
        super(ButtonType.URL, text);
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
    public UrlButton setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets url example.
     *
     * @return the url example
     */
    public List<String> getUrlExample() {
        return urlExample;
    }

    /**
     * Sets url example.
     *
     * @param urlExample the url example
     * @return the url example
     */
    public UrlButton setUrlExample(List<String> urlExample) {
        this.urlExample = urlExample;
        return this;
    }

}
