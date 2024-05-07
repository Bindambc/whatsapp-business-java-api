package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.phone.type.NameStatusType;
import com.whatsapp.api.domain.phone.type.PlatformType;
import com.whatsapp.api.domain.phone.type.QualityRatingType;

/**
 * The type Phone number.
 *
 * @param id The ID associated with the phone number.
 * @param displayPhoneNumber The string representation of the phone number.
 * @param nameStatus The current status of the review of your business name.
 * @param codeVerificationStatus Code Verification Status
 * @param qualityRating The quality rating of the phone number based on how messages have been received by recipients in recent days. Valid values are:
 *         <ul>
 *         <li>Green: High Quality</li>
 *         <li>Yellow: Medium Quality</li>
 *         <li>Red: Low Quality</li>
 *         <li>NA: Quality has not been determined</li>
 *         </ul>
 * @param verifiedName the verified name
 * @param platformType Platform the business phone number is registered with.
 * @param throughput The business phone number's Cloud API throughput level.
 * @see <a href="https://www.facebook.com/business/help/896873687365001">About WhatsApp Business Account Message Quality Rating</a>
 * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account-to-number-current-status/">WhatsApp Business Phone Number</a>
 * @see <a href="https://developers.facebook.com/docs/whatsapp/business-platform/changelog/#september-12--2023">WhatsApp Business Platform - Changelog - September 12, 2023</a>
 */
@JsonInclude(value = Include.NON_NULL)
public record PhoneNumber(

        @JsonProperty("display_phone_number") String displayPhoneNumber,

        @JsonProperty("quality_rating") QualityRatingType qualityRating,

        @JsonProperty("verified_name") String verifiedName,

        @JsonProperty("id") String id,

        @JsonProperty("code_verification_status") String codeVerificationStatus,

        @JsonProperty("name_status") NameStatusType nameStatus,

        @JsonProperty("platform_type") PlatformType platformType,

        @JsonProperty("throughput") Throughput throughput)
{
}