package com.adifferentcolour.starter.resources;

import com.adifferentcolour.starter.domain.Bundle;
import com.adifferentcolour.starter.domain.Product;
import support.api.PackageAPI;
import support.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@Import(TestConfig.class)
public class ProductResourceTest {

    @Autowired
    private PackageAPI packageApi;

    @Test
    public void should_create_bundle() {
        Product product = new Product();
        product.setId("VqKb4tyj9V6i");
        product.setName("Shield");
        product.setUsdPrice(1149);

        Bundle bundle = new Bundle();
        bundle.setDescription("desc");
        bundle.setName("name");
        bundle.setTotalPrice(1149);
        bundle.setProducts(Collections.singletonList(product));

        Bundle createdBundle = packageApi.createPackage(bundle);

        Bundle fetchedPackaged = packageApi.getPackage(createdBundle.getId());

    }


}
