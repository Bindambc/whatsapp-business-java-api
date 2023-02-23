package com.whatsapp.api.impl;

import com.whatsapp.api.domain.media.FileType;
import com.whatsapp.api.domain.media.Media;
import com.whatsapp.api.domain.media.UploadResponse;
import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.service.WhatsappBusinessCloudApiService;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Part;
import okhttp3.ResponseBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static com.whatsapp.api.WhatsappApiServiceGenerator.createService;
import static com.whatsapp.api.WhatsappApiServiceGenerator.executeSync;

/**
 * Implementation of WhatsApp Business Platform Cloud API with synchronous/blocking
 * method calls.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api">WhatsApp Business Platform Cloud API</a>
 */
public class WhatsappBusinessCloudApi {

    private final WhatsappBusinessCloudApiService whatsappBusinessCloudApiService;


    public WhatsappBusinessCloudApi(String token) {
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

        return executeSync(whatsappBusinessCloudApiService.sendMessage(phoneNumberId, message));
    }

    /**
     * You can use the endpoint to upload media:
     *
     * @param phoneNumberId Represents a specific phone number.
     * @param fileName      file name. Ex: photo1.jpg
     * @param file          byte[] - file content
     * @return {@link UploadResponse}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
    public UploadResponse uploadMedia(String phoneNumberId, String fileName, FileType fileType, byte[] file) {

        var requestFile = MultipartBody.create(file, MediaType.parse(fileType.getType()));
        Part body = Part.createFormData("file", fileName, requestFile);

        var messageProduct = Part.createFormData("messaging_product", "whatsapp");


        return executeSync(whatsappBusinessCloudApiService.uploadMedia(phoneNumberId, body, messageProduct));
    }

    public Media retrieveMediaUrl(String mediaId) {
        return executeSync(whatsappBusinessCloudApiService.retrieveMediaUrl(mediaId));

    }

    public ResponseBody downloadFile(String url) throws URISyntaxException {

        URI uri = new URI(url);

        HttpUrl httpUrl = HttpUrl.parse(url);

        assert httpUrl != null;
        var mid = httpUrl.queryParameter("mid");
        var ext = httpUrl.queryParameter("ext");
        var hash = httpUrl.queryParameter("hash");



        var baseUrl = httpUrl.scheme() + "://" + httpUrl.host() + httpUrl.encodedPath();
        return executeSync(whatsappBusinessCloudApiService.downloadFile(baseUrl, mid, ext, hash));
        //  return executeSync(whatsappBusinessCloudApiService.downloadFile(url));

    }

}
