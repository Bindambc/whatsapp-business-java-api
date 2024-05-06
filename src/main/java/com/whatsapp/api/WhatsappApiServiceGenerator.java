package com.whatsapp.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.configuration.WhatsappApiConfig;
import com.whatsapp.api.domain.errors.Error;
import com.whatsapp.api.domain.errors.WhatsappApiError;
import com.whatsapp.api.domain.media.MediaFile;
import com.whatsapp.api.exception.WhatsappApiException;
import com.whatsapp.api.interceptor.AuthenticationInterceptor;
import com.whatsapp.api.utils.proxy.CustomHttpProxySelector;
import com.whatsapp.api.utils.proxy.CustomProxyAuthenticator;
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

    static OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create(
        new ObjectMapper()
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
          .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
          .configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false)
          .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
    );

    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, WhatsappApiError> errorBodyConverter = (Converter<ResponseBody, WhatsappApiError>) converterFactory.responseBodyConverter(WhatsappApiError.class, new Annotation[0], null);

    private WhatsappApiServiceGenerator() {
        throw new IllegalStateException("Cannot instantiate WhatsappApiServiceGenerator is an utility class!");
    }

    static {
        sharedClient = createDefaultHttpClient();
    }

    public static OkHttpClient createDefaultHttpClient() {
        return new OkHttpClient.Builder()//
                .callTimeout(20, TimeUnit.SECONDS)//
                .pingInterval(20, TimeUnit.SECONDS)//
                .build();
    }

    /**
     * Sets http proxy for the shared client.
     * <p>If you need to use a proxy to connect to the internet,
     * you can use this method to set it.
     * <p>
     * <ul>
     * <li>If you want to use a proxy that requires authentication,
     * you can pass the username and password as parameters.
     * <p>
     * <li>If you want to use a proxy that does not require authentication,
     * you can pass {@code null} as parameters for {@code username} and {@code pwd}.
     * </ul>
     * <p>
     *
     * @param host     the host (Not null)
     * @param port     the port
     * @param username the username
     * @param pwd      the pwd
     * @see <a href="https://square.github.io/okhttp/4.x/okhttp/okhttp3/-ok-http-client/-builder/proxy-selector/">Proxy Selector</a>
     * @see <a href="https://square.github.io/okhttp/4.x/okhttp/okhttp3/-ok-http-client/-builder/proxy-authenticator/">Proxy Authenticator</a>
     */
    public static void setHttpProxy(String host, int port, String username, String pwd) {
        Objects.requireNonNull(host, "Host cannot be null");
        CustomHttpProxySelector proxySelector = new CustomHttpProxySelector(host, port);

        sharedClient = sharedClient.newBuilder()
                .proxySelector(proxySelector)
                .build();

        if (username == null || pwd == null) {
            //Without authentication 
            return;
        }

        CustomProxyAuthenticator proxyAuthenticator = new CustomProxyAuthenticator(username, pwd);

        sharedClient = sharedClient.newBuilder()
                .proxyAuthenticator(proxyAuthenticator)
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
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory);

        if (token == null) {
            retrofitBuilder.client(sharedClient);
        } else {

            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(token);
            OkHttpClient adaptedClient = sharedClient.newBuilder()
                    .addInterceptor(interceptor)
                    .build();
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

        var baseUrl = WhatsappApiConfig.getBaseDomain();
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
     * Execute sync file download
     *
     * @param <T>  the type parameter
     * @param call the call
     * @return the t
     */
    public static <T> MediaFile executeDownloadSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {

                var fileName = Objects.requireNonNull(response.headers().get("Content-Disposition")).split("=")[1];
                ResponseBody body = (ResponseBody) response.body();

                assert body != null;
                return new MediaFile(fileName, body.bytes());
            } else {
                if (response.code() == 404) {
                    var error = new Error(404, null, 404, null, "Not found", null, null, null, false, null, null);
                    throw new WhatsappApiException(new WhatsappApiError(error));
                }
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
