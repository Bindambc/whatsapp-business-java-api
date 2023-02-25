package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.media.FileType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;

public class UploadMediaExample {

    public static void main(String[] args) throws IOException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();


        var fileName = "starwars.png";

        byte[] fileContent = Files.readAllBytes(Paths.get("src/test/resources/" + fileName));


        var response = whatsappBusinessCloudApi.uploadMedia(PHONE_NUMBER_ID, fileName, FileType.PNG, fileContent);

        System.out.println(response);
    }


}
