package com.whatsapp.api;

import com.whatsapp.api.configuration.WhatsappApiConfig;
import mockwebserver3.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class MockServerUtilsTest extends TestUtils {
    public static MockWebServer mockWebServer;

    public static String baseUrl;

    @BeforeEach
    public void setUp() throws IOException {

        mockWebServer = new MockWebServer();
        mockWebServer.start();

        baseUrl = String.format("http://localhost:%s", mockWebServer.getPort());
        WhatsappApiConfig.setBaseDomain(baseUrl);

    }

    @AfterEach
    public void tearDown() throws IOException {

        mockWebServer.shutdown();
    }


}
