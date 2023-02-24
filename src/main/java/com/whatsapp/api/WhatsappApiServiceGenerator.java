package com.whatsapp.api;

import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.errors.WhatsappApiError;
import com.whatsapp.api.exception.WhatsappApiException;
import com.whatsapp.api.interceptor.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * The type Whatsapp api service generator.
 */
public class WhatsappApiServiceGenerator {

    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, WhatsappApiError> errorBodyConverter = (Converter<ResponseBody, WhatsappApiError>) converterFactory.responseBodyConverter(WhatsappApiError.class, new Annotation[0], null);

    static {

        sharedClient = new OkHttpClient.Builder()//
                .callTimeout(20, TimeUnit.SECONDS)//
                .pingInterval(20, TimeUnit.SECONDS)//
                .build();
    }

    /**
     * Create service s.
     *
     * @param <S>          the type parameter
     * @param serviceClass the service class
     * @param token        the token
     * @param baseUrl      the base url
     * @return the s
     */
    public static <S> S createService(Class<S> serviceClass, String token, String baseUrl) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(converterFactory);

        if (token == null) {
            retrofitBuilder.client(sharedClient);
        } else {

            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(token);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Create service s.
     *
     * @param <S>          the type parameter
     * @param serviceClass the service class
     * @param token        the token
     * @return the s
     */
    public static <S> S createService(Class<S> serviceClass, String token) {

        var baseUrl = WhatsappApiConfig.BASE_DOMAIN;
        return createService(serviceClass, token, baseUrl);

    }

    /**
     * Execute sync t.
     *
     * @param <T>  the type parameter
     * @param call the call
     * @return the t
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                WhatsappApiError apiError = getWhatsappApiError(response);
                throw new WhatsappApiException(apiError);
            }
        } catch (IOException e) {
            throw new WhatsappApiException(e);
        }
    }

    /**
     * Gets whatsapp api error.
     *
     * @param response the response
     * @return the whatsapp api error
     * @throws WhatsappApiException the whatsapp api exception
     * @throws IOException          the io exception
     */
    public static WhatsappApiError getWhatsappApiError(Response<?> response) throws WhatsappApiException, IOException {
        Objects.requireNonNull(errorBodyConverter);
        ResponseBody responseBody = response.errorBody();
        Objects.requireNonNull(responseBody);
        return errorBodyConverter.convert(responseBody);

    }

    /**
     * Gets shared client.
     *
     * @return the shared client
     */
    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
