package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Currency parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyParameter extends Parameter {
    private String fallbackValue;
    private String code;
    private long amount1000;

    /**
     * Instantiates a new Currency parameter.
     */
    public CurrencyParameter() {
        super(ParameterType.CURRENCY);
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
    public CurrencyParameter setFallbackValue(String fallbackValue) {
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
    public CurrencyParameter setCode(String code) {
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
    public CurrencyParameter setAmount1000(long amount1000) {
        this.amount1000 = amount1000;
        return this;
    }
}
