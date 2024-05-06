package com.whatsapp.api;

import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;
import mockwebserver3.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class MockServerUtilsTest extends TestUtils {

    public static MockWebServer mockWebServer;

    public static String baseUrl;

    public static WhatsappBusinessCloudApi whatsappBusinessCloudApi;

    public static WhatsappBusinessManagementApi whatsappBusinessManagementApi;


    @BeforeEach
    public void setUp() throws IOException {

        mockWebServer = new MockWebServer();
        mockWebServer.start();

        baseUrl = String.format("http://localhost:%s", mockWebServer.getPort());
        WhatsappApiConfig.setBaseDomain(baseUrl);

        String TOKEN = "df4UIkhjdli48574654SDsdf54654sdf5s4DDF54654654654564654sdfsdf54sdf65s4";
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);

        whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        whatsappBusinessManagementApi = factory.newBusinessManagementApi();

    }

    @AfterEach
    public void tearDown() throws IOException {
        mockWebServer.close();
        mockWebServer.shutdown();
    }




}
