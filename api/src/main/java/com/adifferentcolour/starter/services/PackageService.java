package com.adifferentcolour.starter.services;

import com.adifferentcolour.starter.domain.Bundle;
import com.adifferentcolour.starter.exceptions.PriceMismatchException;
import com.adifferentcolour.starter.exceptions.UnknownBundleException;
import com.adifferentcolour.starter.repositories.BundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageService {

    private final ProductService productService;
    private BundleRepository bundleRepository;

    @Autowired
    public PackageService(ProductService productService,
                          BundleRepository bundleRepository) {
        this.productService = productService;
        this.bundleRepository = bundleRepository;
    }


    public Bundle createPackage(Bundle bundle) throws PriceMismatchException {
        productService.validateProductPrices(new ArrayList<>(bundle.getProducts()));

        return bundleRepository.save(bundle);
    }

    public List<Bundle> getAll() {
        return bundleRepository.findAll();
    }

    public Bundle getById(long id) {
        return bundleRepository.findById(id).orElseThrow(UnknownBundleException::new);
    }
}
