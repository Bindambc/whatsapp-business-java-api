package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.phone.type.NameStatusType;
import com.whatsapp.api.domain.phone.type.QualityRatingType;

/**
 * The type Phone number.
 *
 * @param id                     The ID associated with the phone number.
 * @param displayPhoneNumber     The string representation of the phone number.
 * @param nameStatus             The current status of the review of your business name.
 * @param codeVerificationStatus
 * @param qualityRating          The quality rating of the phone number based on how messages have been received by recipients in recent days. Valid values are:
 *                               <ul>
 *                               <li>Green: High Quality</li>
 *                               <li>Yellow: Medium Quality</li>
 *                               <li> Red: Low Quality</li>
 *                               <li>NA: Quality has not been determined</li>
 *                               </ul>
 * @param verifiedName
 * @see <a href="https://www.facebook.com/business/help/896873687365001">About WhatsApp Business Account Message Quality Rating</a>
 */
@JsonInclude(value = Include.NON_NULL)
public record PhoneNumber(

        @JsonProperty("display_phone_number") String displayPhoneNumber,

        @JsonProperty("quality_rating") QualityRatingType qualityRating,

        @JsonProperty("verified_name") String verifiedName,

        @JsonProperty("id") String id,

        @JsonProperty("code_verification_status") String codeVerificationStatus,

        @JsonProperty("name_status") NameStatusType nameStatus) {
}