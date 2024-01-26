package com.whatsapp.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.whatsapp.api.domain.errors.WhatsappApiError;
import com.whatsapp.api.exception.WhatsappApiException;
import com.whatsapp.api.utils.proxy.CustomHttpProxySelector;
import com.whatsapp.api.utils.proxy.CustomProxyAuthenticator;

import okhttp3.Authenticator;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class WhatsappApiServiceGeneratorTest extends TestUtils {

    @BeforeEach
    void resetProxy() {
        WhatsappApiServiceGenerator.sharedClient = WhatsappApiServiceGenerator.createDefaultHttpClient();
    }

    /**
     * Method under test:
     * {@link WhatsappApiServiceGenerator#getSharedClient}
     */
    @Test
    void testGetSharedClient() {

        assertNotNull(WhatsappApiServiceGenerator.getSharedClient(), "Shared client should not be null");
        assertEquals(WhatsappApiServiceGenerator.getSharedClient().getClass(), OkHttpClient.class, "Shared client should be OkHttpClient");

    }

    /**
     * Method under test:
     * {@link WhatsappApiServiceGenerator#getWhatsappApiError}
     * 
     * @throws IOException
     * @throws URISyntaxException
     * @throws WhatsappApiException
     */
    @Test
    void testGetWhatsappApiError() throws IOException, URISyntaxException {

        String verifyCodeErrorBody = fromResource("/phone/verifyCodeError.json");

        Response<?> response = Response.error(400, ResponseBody.create(verifyCodeErrorBody, MediaType.parse("application/json")));
        WhatsappApiError apiError = WhatsappApiServiceGenerator.getWhatsappApiError(response);

        assertEquals(136025, apiError.error().code(), "Error code should be 136025");
        assertEquals(2388093, apiError.error().errorSubcode(), "Error code should be 136025");
        assertEquals(false, apiError.error().isTransient(), "Error code should be 136025");
        assertEquals("O c\u00F3digo inserido est\u00E1 incorreto.", apiError.error().errorUserMsg(), "Error code should be 136025");
        assertEquals("N\u00E3o foi poss\u00EDvel verificar o c\u00F3digo", apiError.error().errorUserSubtitle(), "Error code should be 136025");

    }

    /**
     * Method under test:
     * {@link WhatsappApiServiceGenerator#setHttpProxy(String, int, String, String)}
     */
    @Test
    void testSetHttpProxy_WithoutAuthentication() {

        // Pre-condition Proxy
        assertNull(WhatsappApiServiceGenerator.getSharedClient().proxy(), "Proxy should be null");
        assertEquals(ProxySelector.getDefault(), WhatsappApiServiceGenerator.getSharedClient().proxySelector(),
                "Proxy selector should be null");

        // Set proxy in shared client
        WhatsappApiServiceGenerator.setHttpProxy("localhost", 8080, null, null);

        // Check if proxy is set
        assertNotNull(WhatsappApiServiceGenerator.getSharedClient().proxySelector(), "Proxy selector should not be null");
        assertEquals(WhatsappApiServiceGenerator.getSharedClient().proxySelector().getClass(), CustomHttpProxySelector.class, "Proxy selector should be CustomHttpProxySelector");

        // Check if authenticator is NONE
        assertEquals(Authenticator.NONE, WhatsappApiServiceGenerator.getSharedClient().authenticator(), "Authenticator should be NONE");
    }

    /**
     * Method under test:
     * {@link WhatsappApiServiceGenerator#setHttpProxy(String, int, String, String)}
     */
    @Test
    void testSetHttpProxy_WithAuthentication() {

        // Pre-condition Proxy
        assertNull(WhatsappApiServiceGenerator.getSharedClient().proxy(), "Proxy should be null");
        assertEquals(ProxySelector.getDefault(), WhatsappApiServiceGenerator.getSharedClient().proxySelector(),
                "Proxy selector should be ProxySelector.getDefault()");

        // Pre-condition Authenticator
        assertEquals(Authenticator.NONE, WhatsappApiServiceGenerator.getSharedClient().authenticator(), "Authenticator should be NONE");
        assertEquals(Authenticator.NONE, WhatsappApiServiceGenerator.getSharedClient().proxyAuthenticator(), "Authenticator should be NONE");

        // Set proxy with Authentication in shared client
        WhatsappApiServiceGenerator.setHttpProxy("localhost", 8080, "Proxy-User", "Proxy-Pwd");

        // Check if proxy is set
        assertNotNull(WhatsappApiServiceGenerator.getSharedClient().proxySelector(), "Proxy selector should not be null");
        assertEquals(WhatsappApiServiceGenerator.getSharedClient().proxySelector().getClass(), CustomHttpProxySelector.class, "Proxy selector should be CustomHttpProxySelector");

        // Check if authenticator is CustomProxyAuthenticator
        assertNotNull(WhatsappApiServiceGenerator.getSharedClient().proxyAuthenticator(), "Proxy Authenticator should not be null");
        assertEquals(CustomProxyAuthenticator.class, WhatsappApiServiceGenerator.getSharedClient().proxyAuthenticator().getClass(), "Authenticator should be CustomProxyAuthenticator");

    }
}
