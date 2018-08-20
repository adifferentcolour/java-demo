package com.adifferentcolour.starter.services;

import com.adifferentcolour.starter.domain.LatestCurrencyRates;
import com.adifferentcolour.starter.exceptions.UnknownBundleException;
import com.adifferentcolour.starter.exceptions.UnknownCurrencyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class CurrencyConverterService {

    private static final String URL_PATTERN = "http://data.fixer.io/api/latest?access_key=%s";

    private final RestTemplate restTemplate;
    private final String apiKey;

    @Autowired
    public CurrencyConverterService(String apiKey, RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public int convert(int fromAmount, String toCurrency) throws UnknownBundleException {
        String url = String.format(URL_PATTERN, apiKey);
        LatestCurrencyRates currencyRates = restTemplate.getForObject(URI.create(url), LatestCurrencyRates.class);

        if (!currencyRates.getRates().containsKey(toCurrency)) {
            throw new UnknownCurrencyCode();
        }

        float usdRate = currencyRates.getRates().get("USD");
        float targetRate = currencyRates.getRates().get(toCurrency);

        float eurAmount = (fromAmount > 1 ? fromAmount / usdRate : fromAmount * usdRate);
        float targetAmount = eurAmount * targetRate;

        return Math.round(targetAmount);
    }
}
