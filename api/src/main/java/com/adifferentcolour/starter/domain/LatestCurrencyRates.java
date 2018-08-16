package com.adifferentcolour.starter.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class LatestCurrencyRates {

    private final String name = "java-demo";

    private boolean success;
    private long timestamp;
    private String base;
    private String date;
    private Map<String, Float> rates;
}
