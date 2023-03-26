package com.whatsapp.api.exception;

import com.whatsapp.api.domain.errors.WhatsappApiError;

/**
 * The type Whatsapp api exception.
 */
public class WhatsappApiException extends RuntimeException {
    /**
     * The type  WhatsappApiError
     */
    private WhatsappApiError whatsappApiError;

    /**
     * Instantiates a new Whatsapp api exception.
     */
    public WhatsappApiException() {
        super();
    }

    /**
     * Instantiates a new Whatsapp api exception.
     *
     * @param cause the cause
     */
    public WhatsappApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Whatsapp api exception.
     *
     * @param whatsappApiError the whatsapp api error
     */
    public WhatsappApiException(WhatsappApiError whatsappApiError) {
        this.whatsappApiError = whatsappApiError;
    }

    @Override
    public String getMessage() {
        if (whatsappApiError != null && whatsappApiError.error() != null) {
            if (whatsappApiError.error().errorData() != null && whatsappApiError.error().errorData().details() != null)
                return String.format("[%s] %s | %s", whatsappApiError.error().code(), whatsappApiError.error().message(), whatsappApiError.error().errorData().details());

            if (whatsappApiError.error().errorUserMsg() != null)
                return String.format("[%s] %s | %s", whatsappApiError.error().code(), whatsappApiError.error().message(), whatsappApiError.error().errorUserMsg());

            return whatsappApiError.error().message();
        }

        return super.getMessage();
    }

}
