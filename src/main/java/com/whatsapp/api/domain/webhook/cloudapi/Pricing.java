package com.whatsapp.api.domain.webhook.cloudapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pricing {

    @JsonProperty("pricing_model")
    private String pricingModel;

    @JsonProperty("category")
    private String category;

    @JsonProperty("billable")
    private boolean billable;

    public String getPricingModel() {
        return pricingModel;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBillable() {
        return billable;
    }
}