package com.whatsapp.api;

import com.whatsapp.api.impl.WhatsappBusinessCloudApi;
import com.whatsapp.api.impl.WhatsappBusinessManagementApi;
import mockwebserver3.MockWebServer;
import org.junit.jupiter.api.BeforeAll;


public class MockServerTestUtils extends TestUtils {

    public MockWebServer mockWebServer;

    public String baseUrl;

    public WhatsappBusinessCloudApi whatsappBusinessCloudApi;

    public WhatsappBusinessManagementApi whatsappBusinessManagementApi;


}
