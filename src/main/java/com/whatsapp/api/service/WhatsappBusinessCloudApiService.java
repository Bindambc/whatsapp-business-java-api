package com.whatsapp.api.service;


import com.whatsapp.api.domain.media.Media;
import com.whatsapp.api.domain.media.UploadResponse;
import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.domain.response.Response;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

import static com.whatsapp.api.configuration.WhatsappApiConfig.API_VERSION;


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
    @POST("/" + API_VERSION + "/{Phone-Number-ID}/messages")
    Call<MessageResponse> sendMessage(@Path("Phone-Number-ID") String phoneNumberId, @Body Message message);

    /**
     * Upload media call.
     *
     * @param phoneNumberId  the phone number id
     * @param file           the file
     * @param messageProduct the message product
     * @return the call
     */
    @Multipart
    @POST("/" + API_VERSION + "/{Phone-Number-ID}/media")
    Call<UploadResponse> uploadMedia(@Path("Phone-Number-ID") String phoneNumberId, @Part MultipartBody.Part file, @Part MultipartBody.Part messageProduct);

    /**
     * Retrieve media url call.
     *
     * @param mediaId the media id
     * @return the call
     */
    @GET("/" + API_VERSION + "/{media-id}")
    Call<Media> retrieveMediaUrl(@Path("media-id") String mediaId);


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
    @DELETE("/" + API_VERSION + "/{media-id}")
    Call<Response> deleteMedia(@Path("media-id") String mediaId);

}
