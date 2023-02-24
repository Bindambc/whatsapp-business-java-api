package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Context.
 *
 * @param from                Added to Webhooks if message is an inbound reply to a sent message.                            The WhatsApp ID of the sender of the sent message.
 * @param referredProduct     Required for Product Enquiry Messages. Specifies the product the user is requesting information about.
 * @param id                  Optional. The message ID for the sent message for an inbound reply. Added to Webhooks if message has been frequently forwarded.
 * @param forwarded           Added to Webhooks if message was forwarded. Set to true if the received message has been forwarded.
 * @param frequentlyForwarded Added to Webhooks if message has been frequently forwarded.
 */
public record Context(

        @JsonProperty("from") String from,

        @JsonProperty("referred_product") ReferredProduct referredProduct,

        @JsonProperty("id") String id,

        @JsonProperty("forwarded") boolean forwarded,

        @JsonProperty("frequently_forwarded") boolean frequentlyForwarded

) {

}