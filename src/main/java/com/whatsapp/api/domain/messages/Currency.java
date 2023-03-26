package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Currency.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Currency {
    @JsonProperty("fallback_value")
    private String fallbackValue;
    @JsonProperty("code")
    private String code;
    @JsonProperty("amount_1000")
    private long amount1000;

    /**
     * Instantiates a new Currency.
     */
    public Currency() {
    }

    /**
     * Instantiates a new Currency.
     *
     * @param fallbackValue the fallback value
     * @param code          the code
     * @param amount1000    the amount 1000
     */
    public Currency(String fallbackValue, String code, long amount1000) {
        this.fallbackValue = fallbackValue;
        this.code = code;
        this.amount1000 = amount1000;
    }

    /**
     * Gets fallback value.
     *
     * @return the fallback value
     */
    public String getFallbackValue() {
        return fallbackValue;
    }

    /**
     * Sets fallback value.
     *
     * @param fallbackValue the fallback value
     * @return the fallback value
     */
    public Currency setFallbackValue(String fallbackValue) {
        this.fallbackValue = fallbackValue;
        return this;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     * @return the code
     */
    public Currency setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Gets amount 1000.
     *
     * @return the amount 1000
     */
    public long getAmount1000() {
        return amount1000;
    }

    /**
     * Sets amount 1000.
     *
     * @param amount1000 the amount 1000
     * @return the amount 1000
     */
    public Currency setAmount1000(long amount1000) {
        this.amount1000 = amount1000;
        return this;
    }
}
