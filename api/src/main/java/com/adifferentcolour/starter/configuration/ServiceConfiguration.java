package com.adifferentcolour.starter.configuration;

import com.adifferentcolour.starter.services.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfiguration {

    @Value("${fixer.api-key}")
    private String fixerApiKey;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CurrencyConverterService currencyConverterService(RestTemplate restTemplate) {
        return new CurrencyConverterService(fixerApiKey, restTemplate);
    }
}
