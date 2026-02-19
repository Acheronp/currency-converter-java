package com.currencyconverter.services;

import com.currencyconverter.models.ExchangeRate;

public class Converter {
    public double convert(double amount, String targetCurrency, ExchangeRate rates) {
        Double rate = rates.conversion_rates().get(targetCurrency);
        if (rate == null) {
            throw new RuntimeException("Currency code not found: " + targetCurrency);
        }
        return amount * rate;
    }
}
