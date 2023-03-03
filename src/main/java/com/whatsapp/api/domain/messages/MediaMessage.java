package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Media message.
 *
 * @param <T> the type parameter
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#media-object">Media Object</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MediaMessage<T extends MediaMessage<T>> {

    @JsonProperty("id")
    private String id;
    @JsonProperty("link")
    private String link;


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
     * @param id Required when type is audio, document, image, sticker, or video and you are not using a link.
     * @return the id
     */
    @SuppressWarnings("unchecked")
    public T setId(String id) {
        this.id = id;
        return (T) this;
    }

    /**
     * Gets link.
     *
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets link.
     *
     * @param link Required when type is audio, document, image, sticker, or video and you are not using an uploaded media ID (i.e. you are hosting the media asset on your public server).
     *             The protocol and URL of the media to be sent. Use only with HTTP/HTTPS URLs.
     * @return the link
     */
    @SuppressWarnings("unchecked")
    public T setLink(String link) {
        this.link = link;
        return (T) this;
    }
}
