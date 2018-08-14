package com.adifferentcolour.starter.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductList {
    private List<Product> productList;
}
