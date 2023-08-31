package com.whatsapp.api.utils.proxy;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class CustomProxyAuthenticator implements Authenticator {

    private final String proxyUsername;
    private final String proxyPassword;

    public CustomProxyAuthenticator(final String username, final String password) {
        super();
        this.proxyUsername = username;
        this.proxyPassword = password;
    }

    @Override
    public Request authenticate(final Route route, final Response response) throws IOException {
        final String credential = Credentials.basic(proxyUsername, proxyPassword);
        return response.request().newBuilder()
                .header("Proxy-Authorization", credential)
                .build();
    }
}
