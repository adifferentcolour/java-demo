package com.adifferentcolour.starter.resources;

import com.adifferentcolour.starter.domain.Package;
import com.adifferentcolour.starter.domain.Product;
import support.api.PackageAPI;
import support.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@Import(TestConfig.class)
public class ProductResourceTest {

    @Autowired
    private PackageAPI packageApi;

    @Test
    public void should_create_package() {
        Product product = new Product();
        product.setId("VqKb4tyj9V6i");
        product.setName("Shield");
        product.setUsdPrice(1149);

        Package aPackage = new Package();
        aPackage.setDescription("desc");
        aPackage.setName("name");
        aPackage.setTotalPrice(1149);
        aPackage.setProducts(Collections.singletonList(product));

        Package createdPackage = packageApi.createPackage(aPackage);

        Package fetchedPackaged = packageApi.getPackage(createdPackage.getId());

    }


}
