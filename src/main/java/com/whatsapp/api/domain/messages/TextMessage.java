package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <ul>
 *     <li><b>body</b> Required for text messages.
 *     <p>The text of the text message which can contain URLs which begin with http:// or https:// and formatting. See available formatting options here.
 * If you include URLs in your text and want to include a preview box in text messages (preview_url: true), make sure the URL starts with http:// or https:// —https:// URLs are preferred. You must include a hostname, since IP addresses will not be matched.
 * <b>Maximum length: 4096 characters</b></p>
 *     </li>
 *     <li><b>preview_url</b> optional
 * By default, WhatsApp recognizes URLs and makes them clickable, but you can also include a preview box with more information about the link. Set this field to true if you want to include a URL preview box.
 * The majority of the time, the receiver will see a URL they can click on when you send an URL, set preview_url to true, and provide a body object with a http or https link.
 * URL previews are only rendered after one of the following has happened:
 * The business has sent a message template to the user.
 * The user initiates a conversation with a "click to chat" link.
 * The user adds the business phone number to their address book and initiates a conversation.
 * Default: false.
 * </li>
 *     </ul>
 *     <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#text-object">See oficial documentation</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextMessage {

    @JsonProperty("preview_url")
    private boolean previewUrl;
    @JsonProperty("body")
    private String body;

    /**
     * Is preview url boolean.
     *
     * @return the boolean
     */
    public boolean isPreviewUrl() {
        return previewUrl;
    }

    /**
     * Sets preview url.
     *
     * @param previewUrl the preview url
     * @return the preview url
     */
    public TextMessage setPreviewUrl(boolean previewUrl) {
        this.previewUrl = previewUrl;
        return this;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     * @return the body
     */
    public TextMessage setBody(String body) {
        this.body = body;
        return this;
    }
}
