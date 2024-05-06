package com.whatsapp.api.service;

import com.whatsapp.api.domain.media.Media;
import com.whatsapp.api.domain.media.UploadResponse;
import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.ReadMessage;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.domain.phone.TwoStepCode;
import com.whatsapp.api.domain.response.Response;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * The interface Whatsapp business cloud api service.
 */
public interface WhatsappBusinessCloudApiService {

    /**
     * Send message call.
     *
     * @param phoneNumberId the phone number id
     * @param message       the message
     * @return the call
     */
    @POST("/{api-version}/{Phone-Number-ID}/messages")
    Call<MessageResponse> sendMessage(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body Message message);

    /**
     * Upload media call.
     *
     * @param phoneNumberId  the phone number id
     * @param file           the file
     * @param messageProduct the message product
     * @return the call
     */
    @Multipart
    @POST("/{api-version}/{Phone-Number-ID}/media")
    Call<UploadResponse> uploadMedia(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Part MultipartBody.Part file,
                                     @Part MultipartBody.Part messageProduct);

    /**
     * Retrieve media url call.
     *
     * @param mediaId the media id
     * @return the call
     */
    @GET("/{api-version}/{media-id}")
    Call<Media> retrieveMediaUrl(@Path("api-version") String apiVersion, @Path("media-id") String mediaId);

    /**
     * Download media file call.
     *
     * @param url the url
     * @return the call
     */
    @GET
    @Streaming
    @Headers(value = "User-Agent:curl/7.64.1")
    Call<ResponseBody> downloadMediaFile(@Url String url);

    /**
     * Delete media call.
     *
     * @param mediaId the media id
     * @return the call
     */
    @DELETE("/{api-version}/{media-id}")
    Call<Response> deleteMedia(@Path("api-version") String apiVersion, @Path("media-id") String mediaId);

    /**
     * Send mark Meassge as read call.
     *
     * @param phoneNumberId the phone number id
     * @param message       the message
     * @return the call
     */
    @POST("/{api-version}/{Phone-Number-ID}/messages")
    Call<Response> markMessageAsRead(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body ReadMessage message);

    /**
     * Two-step verification call.
     *
     * @param phoneNumberId the phone number id
     * @param twoStepCode   the two-step code
     * @return the call
     */
    @POST("/{api-version}/{Phone-Number-ID}")
    Call<Response> twoStepVerification(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body TwoStepCode twoStepCode);

}
