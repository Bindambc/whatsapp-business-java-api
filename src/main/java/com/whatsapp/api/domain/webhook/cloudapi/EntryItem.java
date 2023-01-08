package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Generic webhook class wrapper. All Webhooks messages have this.
 *
 * @param changes Changes that triggered the Webhooks call. This field contains an array of change objects.
 * @param id      The ID of Whatsapp Business Accounts this Webhook belongs to.
 */
public record EntryItem(

        /*
        	Changes that triggered the Webhooks call. This field contains an array of change objects.
         */
        @JsonProperty("changes") List<ChangesItem> changes,
        /*
            The ID of Whatsapp Business Accounts this Webhook belongs to.
        */
        @JsonProperty("id") String id

) {
}