package com.whatsapp.api.domain.errors;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object representing errors from the whatsapp api
 *
 * @param code
 * @param details
 * @param errorSubcode
 * @param fbtraceId
 * @param message
 * @param messagingProduct
 * @param errorData
 * @param type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Error(@JsonProperty("code") Integer code, @JsonProperty("details") String details,
                    @JsonProperty("error_subcode") Integer errorSubcode, @JsonProperty("fbtrace_id") String fbtraceId,
                    @JsonProperty("message") @JsonAlias({"message",}) String message, @JsonProperty("messaging_product") String messagingProduct,
                    @JsonProperty("error_data") ErrorData errorData, @JsonProperty("type") String type,

                    @JsonProperty("is_transient") Boolean isTransient,
                    @JsonProperty("error_user_title") String errorUserSubtitle,
                    @JsonProperty("error_user_msg") String errorUserMsg) {
}
