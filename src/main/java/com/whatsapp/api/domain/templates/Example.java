package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Example.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Example {
    @JsonProperty("header_handle")
    private List<String> headerHandle;
    @JsonProperty("body_text")
    private List<List<String>> bodyText;
    @JsonProperty("header_text")
    private List<String> headerText;


    /**
     * Gets header handle.
     *
     * @return the header handle
     */
    public List<String> getHeaderHandle() {
        return headerHandle;
    }

    /**
     * Sets header handle.
     *
     * @param headerHandle the header handle
     * @return the header handle
     */
    public Example setHeaderHandle(List<String> headerHandle) {
        this.headerHandle = headerHandle;
        return this;
    }

    /**
     * Gets body text.
     *
     * @return the body text
     */
    public List<List<String>> getBodyText() {
        return bodyText;
    }

    /**
     * Sets body text.
     *
     * @param bodyText the body text
     * @return the body text
     */
    public Example setBodyText(List<List<String>> bodyText) {
        this.bodyText = bodyText;
        return this;
    }

    /**
     * Gets header text.
     *
     * @return the header text
     */
    public List<String> getHeaderText() {
        return headerText;
    }

    /**
     * Sets header text.
     *
     * @param headerText the header text
     * @return the header text
     */
    public Example setHeaderText(List<String> headerText) {
        this.headerText = headerText;
        return this;
    }

    /**
     * Add header handle example example.
     *
     * @param example the example
     * @return the example
     */
    public Example addHeaderHandleExamples(String... example) {
        if (this.headerHandle == null) this.headerHandle = new ArrayList<>();
        if (example != null) this.headerHandle.addAll(Arrays.stream(example).toList());
        return this;
    }

    /**
     * Add header text example example.
     *
     * @param example the example
     * @return the example
     */
    public Example addHeaderTextExamples(String... example) {
        if (this.headerText == null) this.headerText = new ArrayList<>();
        if (example != null) this.headerText.addAll(Arrays.stream(example).toList());
        return this;
    }

    /**
     * Add body text examples example.
     *
     * @param example the example
     * @return the example
     */
    public Example addBodyTextExamples(String... example) {
        if (bodyText == null) this.bodyText = new ArrayList<>();
        if (example != null) bodyText.add(Arrays.stream(example).toList());
        return this;
    }
}
