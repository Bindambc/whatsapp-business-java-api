package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Origin.
 *
 * @param type Indicates where a conversation has started. This can also be referred to as a conversation entry point. Currently, the available options are:             <ul><li>business_initiated: indicates that the conversation started by a business sending the first message to a user. This applies any time it has been more than 24 hours since the last user message.</li>             <li>user_initiated: indicates that the conversation started by a business replying to a user message. This applies only when the business reply is within 24 hours of the last user message.</li>             <li>referral_conversion: indicates that the conversation originated from a free entry point. These conversations are always user-initiated.</li>                         </ul>
 */
public record Origin(

        @JsonProperty("type") String type

) {
}