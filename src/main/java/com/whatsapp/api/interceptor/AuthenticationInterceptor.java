package com.whatsapp.api.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {

    private final String token;

    public AuthenticationInterceptor(String token) {
        this.token = token;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request() //
                .newBuilder() //
                .addHeader("Authorization", "Bearer " + token) //
                .build();

        return chain.proceed(newRequest);
    }
}
