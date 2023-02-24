
package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Use when button is of type <b>reply</b></p>
 * <ul>
 *     <li><b>id:</b> Unique identifier for your button. This ID is returned in the webhook when the button is clicked by the user. Maximum length: 256 characters.</li>
 *     <li><b>title:</b> Button title. It cannot be an empty string and must be unique within the message. Emojis are supported, markdown is not. Maximum length: 20 characters.</li>
 * </ul>
 */
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
