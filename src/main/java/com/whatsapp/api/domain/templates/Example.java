package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Example {
    @JsonProperty("header_handle")
    private List<String> headerHandle;
    @JsonProperty("body_text")
    private List<List<String>> bodyText;
    @JsonProperty("header_text")
    private List<String> headerText;


    public List<String> getHeaderHandle() {
        return headerHandle;
    }

    public Example setHeaderHandle(List<String> headerHandle) {
        this.headerHandle = headerHandle;
        return this;
    }

    public List<List<String>> getBodyText() {
        return bodyText;
    }

    public Example setBodyText(List<List<String>> bodyText) {
        this.bodyText = bodyText;
        return this;
    }

    public List<String> getHeaderText() {
        return headerText;
    }

    public Example setHeaderText(List<String> headerText) {
        this.headerText = headerText;
        return this;
    }

    public Example addHeaderHandleExample(String... example) {
        if (this.headerHandle == null) this.headerHandle = new ArrayList<>();
        if (example != null) this.headerHandle.addAll(Arrays.stream(example).toList());
        return this;
    }

    public Example addHeaderTextExample(String... example) {
        if (this.headerText == null) this.headerText = new ArrayList<>();
        if (example != null) this.headerText.addAll(Arrays.stream(example).toList());
        return this;
    }

    public Example addBodyTextExamples(String... example) {
        if (bodyText == null) this.bodyText = new ArrayList<>();
        if (example != null) bodyText.add(Arrays.stream(example).toList());
        return this;
    }
}
