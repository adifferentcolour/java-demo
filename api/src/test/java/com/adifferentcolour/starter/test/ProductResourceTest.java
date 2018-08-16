package com.adifferentcolour.starter.test;

import com.adifferentcolour.starter.domain.Bundle;
import com.adifferentcolour.starter.domain.Product;
import com.adifferentcolour.starter.test.support.api.PackageAPI;
import com.adifferentcolour.starter.test.support.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@Import(TestConfig.class)
public class ProductResourceTest {

    @Autowired
    private PackageAPI packageApi;

    @Test
    public void should_create_bundle() {
        Product product = Product.builder()
                .id("VqKb4tyj9V6i")
                .name("Shield")
                .usdPrice(1149)
                .build();

        Bundle bundle = Bundle.builder()
                .description("desc")
                .name("name")
                .totalPrice(1149)
                .products(new HashSet<>(Collections.singletonList(product)))
                .build();

        Bundle createdBundle = packageApi.createPackage(bundle);

        Bundle fetchedPackaged = packageApi.getPackage(createdBundle.getId());

    }


}
