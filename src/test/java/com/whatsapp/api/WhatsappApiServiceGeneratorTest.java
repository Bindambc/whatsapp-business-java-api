package com.whatsapp.api;

import com.whatsapp.api.domain.errors.WhatsappApiError;
import com.whatsapp.api.utils.proxy.CustomHttpProxySelector;
import com.whatsapp.api.utils.proxy.CustomProxyAuthenticator;
import okhttp3.Authenticator;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URISyntaxException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


class WhatsappApiServiceGeneratorTest extends TestUtils {

    @BeforeEach
    void resetProxy() {
        WhatsappApiServiceGenerator.sharedClient = WhatsappApiServiceGenerator.createDefaultHttpClient();
    }


    @AfterAll
    static void resetSharedOkHttpClientToDefault() {
        // reset the OkHttpClient to its default settings, preventing errors in other tests that do not utilize a proxy
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
     */
    @Test
    void testGetWhatsappApiError() throws IOException, URISyntaxException {

        String verifyCodeErrorBody = fromResource("/phone/verifyCodeError.json");

        Response<?> response = Response.error(400, ResponseBody.create(verifyCodeErrorBody, MediaType.parse("application/json")));
        WhatsappApiError apiError = WhatsappApiServiceGenerator.getWhatsappApiError(response);

        assertEquals(136025, apiError.error().code(), "Error code should be 136025");
        assertEquals(2388093, apiError.error().errorSubcode(), "Error code should be 136025");
        assertEquals(false, apiError.error().isTransient(), "Error code should be 136025");
        assertEquals("O código inserido está incorreto.", apiError.error().errorUserMsg(), "Error code should be 136025");
        assertEquals("Não foi possível verificar o código", apiError.error().errorUserSubtitle(), "Error code should be 136025");

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

    /**
     * Method under test:
     * {@link WhatsappApiServiceGenerator#setTimeout(Duration)}
     */
    @Test
    void testSetTimeout() {

        assertEquals( 20 * 1000, WhatsappApiServiceGenerator.getSharedClient().callTimeoutMillis() );

        // Set timeout in shared client
        WhatsappApiServiceGenerator.setTimeout( Duration.ofMinutes( 1L ) );

        // Check if timeout is set
        assertEquals( 60 * 1000, WhatsappApiServiceGenerator.getSharedClient().callTimeoutMillis() );
    }

}
