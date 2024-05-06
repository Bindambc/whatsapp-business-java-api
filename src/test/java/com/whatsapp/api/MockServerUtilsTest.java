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


public class MockServerUtilsTest extends TestUtils {

    public static MockWebServer mockWebServer;

    public static String baseUrl;

    public static WhatsappBusinessCloudApi whatsappBusinessCloudApi;

    public static WhatsappBusinessManagementApi whatsappBusinessManagementApi;







}
