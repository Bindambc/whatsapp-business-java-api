package com.whatsapp.api.exception;

import com.whatsapp.api.domain.errors.Error;
import com.whatsapp.api.domain.errors.ErrorData;
import com.whatsapp.api.domain.errors.WhatsappApiError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class WhatsappApiExceptionTest {
    /**
     * Method under test: {@link WhatsappApiException#WhatsappApiException()}
     */
    @Test
    void testConstructor() {
        WhatsappApiException actualWhatsappApiException = new WhatsappApiException();
        assertNull(actualWhatsappApiException.getCause());
        assertEquals(0, actualWhatsappApiException.getSuppressed().length);
        assertNull(actualWhatsappApiException.getMessage());
        assertNull(actualWhatsappApiException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link WhatsappApiException#WhatsappApiException(WhatsappApiError)}
     */
    @Test
    void testConstructor2() {
        WhatsappApiException actualWhatsappApiException = new WhatsappApiException(
                new WhatsappApiError(new Error(1, "Details", -1, "42", "Not all who wander are lost", "Messaging Product",
                        new ErrorData("Messaging Product", "Details", "Blame Field Specs"), "Type", true, "Dr",
                        "An error occurred")));
        assertNull(actualWhatsappApiException.getCause());
        assertEquals(0, actualWhatsappApiException.getSuppressed().length);
        assertEquals("Not all who wander are lost | Details", actualWhatsappApiException.getMessage());
        assertEquals("Not all who wander are lost | Details", actualWhatsappApiException.getLocalizedMessage());
    }

    /**
     * Method under test: {@link WhatsappApiException#WhatsappApiException(Throwable)}
     */
    @Test
    void testConstructor3() {
        Throwable throwable = new Throwable();
        WhatsappApiException actualWhatsappApiException = new WhatsappApiException(throwable);
        Throwable cause = actualWhatsappApiException.getCause();
        assertSame(throwable, cause);
        Throwable[] suppressed = actualWhatsappApiException.getSuppressed();
        assertEquals(0, suppressed.length);
        assertEquals("java.lang.Throwable", actualWhatsappApiException.getLocalizedMessage());
        assertEquals("java.lang.Throwable", actualWhatsappApiException.getMessage());
        assertNull(cause.getLocalizedMessage());
        assertNull(cause.getCause());
        assertNull(cause.getMessage());
        assertSame(suppressed, cause.getSuppressed());
    }

    /**
     * Method under test: {@link WhatsappApiException#getMessage()}
     */
    @Test
    void testGetMessage() {
        assertNull((new WhatsappApiException()).getMessage());
        assertEquals("Not all who wander are lost | Details",
                (new WhatsappApiException(
                        new WhatsappApiError(new Error(1, "Details", -1, "42", "Not all who wander are lost",
                                "Messaging Product", new ErrorData("Messaging Product", "Details", "Blame Field Specs"), "Type",
                                true, "Dr", "An error occurred")))).getMessage());
        assertEquals("Not all who wander are lost | An error occurred",
                (new WhatsappApiException(
                        new WhatsappApiError(new Error(1, "Details", -1, "42", "Not all who wander are lost",
                                "Messaging Product", new ErrorData("Messaging Product", null, "Blame Field Specs"), "Type", true,
                                "Dr", "An error occurred")))).getMessage());
        assertEquals("Not all who wander are lost | An error occurred",
                (new WhatsappApiException(new WhatsappApiError(new Error(1, "Details", -1, "42",
                        "Not all who wander are lost", "Messaging Product", null, "Type", true, "Dr", "An error occurred"))))
                        .getMessage());
        assertNull((new WhatsappApiException(new WhatsappApiError(null))).getMessage());
        assertEquals("Not all who wander are lost",
                (new WhatsappApiException(new WhatsappApiError(
                        new Error(1, "Details", -1, "42", "Not all who wander are lost", "Messaging Product",
                                new ErrorData("Messaging Product", null, "Blame Field Specs"), "Type", true, "Dr", null))))
                        .getMessage());
    }
}

