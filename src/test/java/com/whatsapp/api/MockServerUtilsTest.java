package com.whatsapp.api;

import com.whatsapp.api.configuration.WhatsappApiConfig;
import mockwebserver3.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class MockServerUtilsTest extends TestUtils {
    public static MockWebServer mockWebServer;

    public static String baseUrl;

    @BeforeAll
    public static void setUp() throws IOException {

        mockWebServer = new MockWebServer();
        mockWebServer.start();

    }

    @AfterAll
    public static void tearDown() throws IOException {

        mockWebServer.shutdown();
    }

    @BeforeEach
    public void initialize() {

        baseUrl = String.format("http://localhost:%s", mockWebServer.getPort());
        WhatsappApiConfig.setBaseDomain(baseUrl);
    }

}
