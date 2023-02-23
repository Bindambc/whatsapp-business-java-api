package com.whatsapp.api.examples;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static com.whatsapp.api.TestConstants.TOKEN;

public class DownloadMediaExample {

    public static void main(String[] args) throws IOException, URISyntaxException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();





        var response = whatsappBusinessCloudApi.retrieveMediaUrl( "1227829768162607");
        var url = new URL(response.url());



       var file = whatsappBusinessCloudApi.downloadFile(response.url());
     //  var file = whatsappBusinessCloudApi.downloadFile("https://api.alternative.me/fng/?limit=10&format=csv");

       System.out.println(file);

//1227829768162607
        System.out.println(response);
    }


}
