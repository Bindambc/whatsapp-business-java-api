package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.InteractiveType;

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE;

/**
 * The type Interactive.
 *
 * @param listReply   Used on Webhooks related to List Messages                    Contains a list {@link ListReply} object.
 * @param type        Contains the type of interactive object. Supported options are:<ul>                    <li>button_reply: for responses of Reply Buttons.</li>                    <li>list_reply: for responses to List Messages and other interactive objects.</li></ul>
 * @param buttonReply Used on Webhooks related to Reply Buttons.                    Contains a {@link ButtonReply} reply object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(with = READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)
public record Interactive(

        @JsonProperty("list_reply") ListReply listReply,

        @JsonProperty("type") InteractiveType type,

        @JsonProperty("button_reply") ButtonReply buttonReply) {

}