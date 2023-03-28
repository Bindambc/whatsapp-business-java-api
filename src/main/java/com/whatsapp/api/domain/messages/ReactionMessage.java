package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Reaction message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReactionMessage {
    @JsonProperty("message_id")
    private String messageId;
    @JsonProperty("emoji")
    private String emoji;

    /**
     * Instantiates a new Reaction message.
     *
     * @param messageId <b>required</b>. The WhatsApp Message ID (wamid) of the message on which the reaction should appear. The reaction will not be sent if:
     *                  <ul>
     *                      <li>
     *                          The message is older than 30 days
     *                      </li>
     *                      <li>
     *                        The message is a reaction message
     *                      </li>
     *                      <li>The message has been deleted</li>
     *                  </ul>
     *                  If the ID is of a message that has been deleted, the message will not be delivered.
     * @param emoji     <b>required</b>. Emoji to appear on the message.
     *                          <ul>
     *                  <li>All emojis supported by Android and iOS devices are supported.</li>
     *                                  <li>Rendered-emojis are supported.</li>
     *                                  <li>If using emoji unicode values, values must be Java- or JavaScript-escape encoded.</li>
     *                                  <li>Only one emoji can be sent in a reaction message</li>
     *                                  <li>Use an empty string to remove a previously sent emoji.</li>
     *
     *                          </ul>
     */
    public ReactionMessage(String messageId, String emoji) {
        this.messageId = messageId;
        this.emoji = emoji;
    }

    /**
     * Instantiates a new Reaction message.
     */
    public ReactionMessage() {
    }

    /**
     * Gets message id.
     *
     * @return the message id
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets message id.
     *
     * @param messageId <b>required</b>. The WhatsApp Message ID (wamid) of the message on which the reaction should appear. The reaction will not be sent if:
     *                  <ul>
     *                      <li>
     *                          The message is older than 30 days
     *                      </li>
     *                      <li>
     *                        The message is a reaction message
     *                      </li>
     *                      <li>The message has been deleted</li>
     *                  </ul>
     *                  If the ID is of a message that has been deleted, the message will not be delivered.
     * @return ReactionMessage
     */
    public ReactionMessage setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    /**
     * Gets emoji.
     *
     * @return the emoji
     */
    public String getEmoji() {
        return emoji;
    }

    /**
     * Sets emoji.
     *
     * @param emoji <b>required</b>. Emoji to appear on the message.
     *                      <ul>
     *              <li>All emojis supported by Android and iOS devices are supported.</li>
     *                              <li>Rendered-emojis are supported.</li>
     *                              <li>If using emoji unicode values, values must be Java- or JavaScript-escape encoded.</li>
     *                              <li>Only one emoji can be sent in a reaction message</li>
     *                              <li>Use an empty string to remove a previously sent emoji.</li>
     *
     *                      </ul>
     * @return ReactionMessage
     */
    public ReactionMessage setEmoji(String emoji) {
        this.emoji = emoji;
        return this;
    }
}
