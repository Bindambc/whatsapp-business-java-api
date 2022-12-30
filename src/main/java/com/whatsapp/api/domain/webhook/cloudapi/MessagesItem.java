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

    @JsonProperty("location")
    private Location location;

    @JsonProperty("contacts")
    private List<ContactsItem> contacts;


    @JsonProperty("button")
    private Button button;

    @JsonProperty("context")
    private Context context;

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

    @JsonProperty("interactive")
    private Interactive interactive;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("referral")
    private Referral referral;

    @JsonProperty("order")
    private Order order;

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

    public Location getLocation() {
        return location;
    }

    public List<ContactsItem> getContacts() {
        return contacts;
    }

    public Interactive getInteractive() {
        return interactive;
    }

    public Button getButton() {
        return button;
    }

    public Context getContext() {
        return context;
    }

    public Referral getReferral() {
        return referral;
    }

    public Order getOrder() {
        return order;
    }
}