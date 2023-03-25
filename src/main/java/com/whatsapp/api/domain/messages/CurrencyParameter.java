package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Currency parameter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyParameter extends Parameter {

    @JsonProperty("currency")
    private Currency currency;

    /**
     * Instantiates a new Currency parameter.
     */
    public CurrencyParameter() {
        super(ParameterType.CURRENCY);
    }

    /**
     * Instantiates a new Currency parameter.
     *
     * @param currency the currency
     */
    public CurrencyParameter(Currency currency) {
        super(ParameterType.CURRENCY);
        this.currency = currency;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     * @return the currency
     */
    public CurrencyParameter setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }
}
