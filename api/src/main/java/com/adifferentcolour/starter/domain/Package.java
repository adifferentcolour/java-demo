package com.adifferentcolour.starter.domain;

import lombok.Data;

import java.util.List;

@Data
public class Package {
    private int id;
    private String name;
    private String description;
    private List<Product> productList;
    private int totalPrice;
}
