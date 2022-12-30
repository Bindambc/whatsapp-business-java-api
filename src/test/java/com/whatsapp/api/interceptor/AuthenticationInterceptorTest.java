package com.whatsapp.api.interceptor;

import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


class AuthenticationInterceptorTest {

    /**
     * Method under test: {@link AuthenticationInterceptor#AuthenticationInterceptor(String)}
     */
    @Test
    void testConstructor() {

        var interceptor = new AuthenticationInterceptor("ABC123");
        Assertions.assertNotNull(interceptor);

    }
}

