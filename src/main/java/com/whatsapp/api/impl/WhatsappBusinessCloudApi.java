package com.whatsapp.api.impl;

import com.whatsapp.api.configuration.ApiVersion;
import com.whatsapp.api.domain.media.FileType;
import com.whatsapp.api.domain.media.Media;
import com.whatsapp.api.domain.media.MediaFile;
import com.whatsapp.api.domain.media.UploadResponse;
import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.ReadMessage;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.domain.phone.TwoStepCode;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.service.WhatsappBusinessCloudApiService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Part;

import static com.whatsapp.api.WhatsappApiServiceGenerator.*;
import static com.whatsapp.api.configuration.WhatsappApiConfig.getApiVersion;

/**
 * Implementation of WhatsApp Business Platform Cloud API with synchronous/blocking
 * method calls.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api">WhatsApp Business Platform Cloud API</a>
 */
public class WhatsappBusinessCloudApi {

    private final WhatsappBusinessCloudApiService whatsappBusinessCloudApiService;

    private final ApiVersion apiVersion;

    /**
     * Instantiates a new Whatsapp business cloud api.
     *
     * @param token the token
     */
    public WhatsappBusinessCloudApi(String token) {
        this.apiVersion = getApiVersion();
        this.whatsappBusinessCloudApiService = createService(WhatsappBusinessCloudApiService.class, token);

    }


    /**
     * Instantiates a new Whatsapp business cloud api, specifying API version
     *
     * @param token      the token
     * @param apiVersion api version
     */
    public WhatsappBusinessCloudApi(String token, ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
        this.whatsappBusinessCloudApiService = createService(WhatsappBusinessCloudApiService.class, token);

    }

    /**
     * Use this endpoint to send text, media, contacts, location, and interactive messages,
     * as well as message templates to your customers.
     *
     * @param phoneNumberId Represents a specific phone number.
     * @param message       The {@link Message} object.
     * @return {@link MessageResponse}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages">official documentation</a>
     */
    public MessageResponse sendMessage(String phoneNumberId, Message message) {

        return executeSync(whatsappBusinessCloudApiService.sendMessage(apiVersion.getValue(), phoneNumberId, message));
    }

    /**
     * You can use the endpoint to upload media:
     * All media files sent through this endpoint are encrypted and persist for 30 days, unless they are deleted earlier
     * <p>The maximum supported file size for media messages on Cloud API is 100MB. In the event the customer sends a file that is greater than 100MB, you will receive a webhook with error code 131052 and title:
     * "Media file size too big. Max file size we currently support: 100MB. Please communicate with your customer to send a media file that is smaller than 100MB"_.
     * We advise that you send customers a warning message that their media file exceeds the maximum file size when this webhook event is triggered.</p>
     *
     * @param phoneNumberId Business phone number ID. If included, the operation will only be processed if the ID matches the ID of the business phone number that the media was uploaded on.
     * @param fileName      file name. Ex: photo1.jpg
     * @param fileType      the file type. See {@link FileType}
     * @param file          byte[] - file content
     * @return {@link UploadResponse}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
    public UploadResponse uploadMedia(String phoneNumberId, String fileName, FileType fileType, byte[] file) {

        var requestFile = MultipartBody.create(file, MediaType.parse(fileType.getType()));
        Part body = Part.createFormData("file", fileName, requestFile);

        var messageProduct = Part.createFormData("messaging_product", "whatsapp");

        return executeSync(whatsappBusinessCloudApiService.uploadMedia(apiVersion.getValue(), phoneNumberId, body, messageProduct));
    }

    /**
     * Retrieve {@link Media} object. A successful response includes an object with a media url. The URL is only valid for 5 minutes. To use this URL, see {@link WhatsappBusinessCloudApi#downloadMediaFile(String)}
     *
     * @param mediaId the media id
     * @return the media
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
    public Media retrieveMediaUrl(String mediaId) {
        return executeSync(whatsappBusinessCloudApiService.retrieveMediaUrl(apiVersion.getValue(), mediaId));

    }

    /**
     * Download media file from whatsapp server
     *
     * @param url the url
     * @return the media file {@link MediaFile}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
    public MediaFile downloadMediaFile(String url) {

        return executeDownloadSync(whatsappBusinessCloudApiService.downloadMediaFile(url));

    }

    /**
     * Delete media from whatsapp server
     *
     * @param mediaId the media id
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
    public Response deleteMedia(String mediaId) {

        return executeSync(whatsappBusinessCloudApiService.deleteMedia(apiVersion.getValue(), mediaId));
    }

    /**
     * Mark a message as Read
     *
     * @param phoneNumberId Represents a specific phone number.
     * @param message       The {@link ReadMessage} object.
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/mark-message-as-read">official documentation</a>
     */
    public Response markMessageAsRead(String phoneNumberId, ReadMessage message) {
        return executeSync(whatsappBusinessCloudApiService.markMessageAsRead(apiVersion.getValue(), phoneNumberId, message));
    }

    /**
     * Business Solution Providers (BSPs) must authenticate themselves with
     * an access token with the whatsapp_business_management permission.
     *
     * @param phoneNumberId Represents a specific phone number.
     * @param twoStepCode   The {@link TwoStepCode} object.
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/two-step-verification">official documentation</a>
     */
    public Response twoStepVerification(String phoneNumberId, TwoStepCode twoStepCode) {
        return executeSync(whatsappBusinessCloudApiService.twoStepVerification(apiVersion.getValue(), phoneNumberId, twoStepCode));
    }

}
