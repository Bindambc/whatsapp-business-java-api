package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MessagesItem {

    @JsonProperty("reaction")
    private Reaction reaction;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("sticker")
    private Sticker sticker;

    @JsonProperty("from")
    private String from;

    @JsonProperty("id")
    private String id;

    @JsonProperty("text")
    private Text text;
    @JsonProperty("errors")
    private List<ErrorsItem> errors;

    @JsonProperty("type")
    private String type;

    @JsonProperty("timestamp")
    private String timestamp;

    public Reaction getReaction() {
        return reaction;
    }

    public Image getImage() {
        return image;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public List<ErrorsItem> getErrors() {
        return errors;
    }

    public String getFrom() {
        return from;
    }

    public String getId() {
        return id;
    }

    public Text getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getTimestamp() {
        return timestamp;
    }
}