package com.whatsapp.api;

import com.whatsapp.api.configuration.WhatsappApiConfig;
import mockwebserver3.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class MockServerUtilsTest {
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

    public String fromResource(String fileName) throws IOException, URISyntaxException {

        byte[] encoded = Files.readAllBytes(Paths.get(Objects.requireNonNull(this.getClass() //
                .getResource(fileName)).toURI()));
        return new String(encoded, StandardCharsets.UTF_8);


    }
}
