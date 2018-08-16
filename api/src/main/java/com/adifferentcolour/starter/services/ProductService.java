package com.adifferentcolour.starter.services;

import com.adifferentcolour.starter.domain.Product;
import com.adifferentcolour.starter.exceptions.PriceMismatchException;
import com.adifferentcolour.starter.exceptions.UnknownProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {

    private static final String PRODUCTS_URL = "https://product-service.herokuapp.com/api/v1/products";

    private final RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void validateProductPrices(List<Product> requestProductList) throws PriceMismatchException {
        List<Product> currentProductList = getAllProducts("user", "pass");

        for (Product requestedProduct : requestProductList) {
            Product currentProduct = getByProductId(currentProductList, requestedProduct.getId());
            if (requestedProduct.getUsdPrice() != currentProduct.getUsdPrice()) {
                throw new PriceMismatchException();
            }
        }
    }

    private List<Product> getAllProducts(String username, String password) {
        final String plainCreds = username + ":" + password;
        final byte[] plainCredsBytes = plainCreds.getBytes();
        final byte[] base64CredsBytes = Base64Utils.encode(plainCredsBytes);
        final String base64Creds = new String(base64CredsBytes);

        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Basic " + base64Creds);
        HttpEntity<String> request = new HttpEntity<String>(headers);


        return restTemplate.exchange(PRODUCTS_URL, HttpMethod.GET, request, new ParameterizedTypeReference<List<Product>>(){}).getBody();
    }

    private Product getByProductId(List<Product> productList, String productId) throws UnknownProductException {
        return productList.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(UnknownProductException::new);
    }
}
