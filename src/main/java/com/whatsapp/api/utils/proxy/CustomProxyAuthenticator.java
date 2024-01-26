package com.whatsapp.api.utils.proxy;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class CustomProxyAuthenticator implements Authenticator {

    private final String CREDENTIALS;

    public CustomProxyAuthenticator(final String username, final String password) {
        CREDENTIALS = Credentials.basic(username, password);
    }

    @Override
    public Request authenticate(final Route route, final Response response) throws IOException {
        return response.request().newBuilder()
                .header("Proxy-Authorization", CREDENTIALS)
                .build();
    }
}
