package com.whatsapp.api.exception;

import com.whatsapp.api.domain.errors.WhatsappApiError;

public class WhatsappApiException extends RuntimeException {

    private WhatsappApiError whatsappApiError;

    public WhatsappApiException() {
        super();
    }

    public WhatsappApiException(Throwable cause) {
        super(cause);
    }

    public WhatsappApiException(WhatsappApiError whatsappApiError) {
        this.whatsappApiError = whatsappApiError;
    }

    @Override
    public String getMessage() {
        if (whatsappApiError != null && whatsappApiError.error() != null) {
            if (whatsappApiError.error().errorData() != null && whatsappApiError.error().errorData().details() != null)
                return whatsappApiError.error().message() + " | " + whatsappApiError.error().errorData().details();

            if (whatsappApiError.error().errorUserMsg() != null)
                return whatsappApiError.error().message() + " | " + whatsappApiError.error().errorUserMsg();

            return whatsappApiError.error().message();
        }

        return super.getMessage();
    }

}
