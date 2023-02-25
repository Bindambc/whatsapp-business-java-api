package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.whatsapp.api.TestConstants.TOKEN;

public class DownloadMediaExample {

    public static void main(String[] args) throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        // retrieve the media file url
        var mediaUrl = whatsappBusinessCloudApi.retrieveMediaUrl("723050006231302");

        //call downloadMediaFile() -> return a MediaFile object with the file name and content (byte[])
        var mediaFile = whatsappBusinessCloudApi.downloadMediaFile(mediaUrl.url());

        //write the file in the folder "/examples/"
        Files.write(Path.of("src/test/java/com/whatsapp/api/examples/" + mediaFile.fileName()), mediaFile.content());

    }


}
