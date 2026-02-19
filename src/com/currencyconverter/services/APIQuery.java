package com.currencyconverter.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import com.currencyconverter.models.ExchangeRate;
import com.google.gson.Gson;

public class APIQuery {
    private final String apiKey = "";

    public ExchangeRate fetchExchangeRates(String baseCode) {
        String address = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCode;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRate.class);
        } catch (Exception e) {
            throw new RuntimeException("Could not fetch exchange rates.");
        }
    }
}
