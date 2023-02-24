package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.messages.type.ParameterType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyParameter extends Parameter {
    private String fallbackValue;
    private String code;
    private long amount1000;

    public CurrencyParameter() {
        super(ParameterType.CURRENCY);
    }

    public String getFallbackValue() {
        return fallbackValue;
    }

    public CurrencyParameter setFallbackValue(String fallbackValue) {
        this.fallbackValue = fallbackValue;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CurrencyParameter setCode(String code) {
        this.code = code;
        return this;
    }

    public long getAmount1000() {
        return amount1000;
    }

    public CurrencyParameter setAmount1000(long amount1000) {
        this.amount1000 = amount1000;
        return this;
    }
}
