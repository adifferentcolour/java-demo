package com.adifferentcolour.starter.services;

import com.adifferentcolour.starter.domain.LatestCurrencyRates;
import com.adifferentcolour.starter.services.CurrencyConverterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyConverterServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private LatestCurrencyRates currencyRates;
    private CurrencyConverterService currencyConverterService;

    @Before
    public void setup() {
        Map<String, Float> ratesMap = new HashMap<>();
        ratesMap.put("USD", 1.140348f);
        ratesMap.put("NZD", 1.727229f);
        ratesMap.put("GBP", 0.895344f);
        ratesMap.put("CNY", 7.56199f);
        ratesMap.put("JPY", 126.261618f);
        ratesMap.put("EUR", 1f);
        currencyRates = LatestCurrencyRates.builder()
                .rates(ratesMap)
                .build();
    }

    @Test
    public void givenUsd_shouldCovertToEur() {
        when(restTemplate.getForObject(isA(URI.class), eq(LatestCurrencyRates.class))).thenReturn(currencyRates);
        currencyConverterService = new CurrencyConverterService("", restTemplate);

        int actualValue = currencyConverterService.convert(100, "EUR");

        assertThat(actualValue, is(88));
    }

    @Test
    public void givenUsd_shouldCovertToNzd() {
        when(restTemplate.getForObject(isA(URI.class), eq(LatestCurrencyRates.class))).thenReturn(currencyRates);
        currencyConverterService = new CurrencyConverterService("", restTemplate);

        int actualValue = currencyConverterService.convert(100, "NZD");

        assertThat(actualValue, is(151));
    }

    @Test
    public void givenUsd_shouldCovertToGbp() {
        when(restTemplate.getForObject(isA(URI.class), eq(LatestCurrencyRates.class))).thenReturn(currencyRates);
        currencyConverterService = new CurrencyConverterService("", restTemplate);

        int actualValue = currencyConverterService.convert(100, "GBP");

        assertThat(actualValue, is(79));
    }

    @Test
    public void givenUsd_shouldCovertToYen() {
        when(restTemplate.getForObject(isA(URI.class), eq(LatestCurrencyRates.class))).thenReturn(currencyRates);
        currencyConverterService = new CurrencyConverterService("", restTemplate);

        int actualValue = currencyConverterService.convert(100, "JPY");

        assertThat(actualValue, is(11072));
    }

    @Test
    public void givenUsd_shouldCovertToYaun() {
        when(restTemplate.getForObject(isA(URI.class), eq(LatestCurrencyRates.class))).thenReturn(currencyRates);
        currencyConverterService = new CurrencyConverterService("", restTemplate);

        int actualValue = currencyConverterService.convert(100, "CNY");

        assertThat(actualValue, is(663));
    }
}
