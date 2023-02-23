
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reply {

    @JsonProperty("id")
    public String id;
    @JsonProperty("title")
    public String title;

    public String getId() {
        return id;
    }

    public Reply setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Reply setTitle(String title) {
        this.title = title;
        return this;
    }
}
