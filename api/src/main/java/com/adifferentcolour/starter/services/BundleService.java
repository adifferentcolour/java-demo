package com.adifferentcolour.starter.services;

import com.adifferentcolour.starter.domain.Bundle;
import com.adifferentcolour.starter.domain.Product;
import com.adifferentcolour.starter.exceptions.PriceMismatchException;
import com.adifferentcolour.starter.exceptions.UnknownBundleException;
import com.adifferentcolour.starter.repositories.BundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BundleService {

    private final ProductService productService;
    private BundleRepository bundleRepository;

    @Autowired
    public BundleService(ProductService productService,
                         BundleRepository bundleRepository) {
        this.productService = productService;
        this.bundleRepository = bundleRepository;
    }


    public Bundle savePackage(Bundle bundle) throws PriceMismatchException {
        productService.validateProductPrices(new ArrayList<>(bundle.getProducts()));
        bundle.setTotalPrice(bundle.getProducts().stream().mapToInt(Product::getUsdPrice).sum());
        return bundleRepository.saveAndFlush(bundle);
    }

    public Bundle updatePackage(Bundle bundle) throws PriceMismatchException, UnknownBundleException {
        if (!bundleRepository.existsById(bundle.getId())) {
            throw new UnknownBundleException();
        }
        return savePackage(bundle);
    }

    public List<Bundle> getAll() {
        return bundleRepository.findAll();
    }

    public Bundle getById(long id) throws UnknownBundleException {
        return bundleRepository.findById(id).orElseThrow(UnknownBundleException::new);
    }

    public void delete(long id) throws UnknownBundleException {
        if (!bundleRepository.existsById(id)) {
            throw new UnknownBundleException();
        }

        bundleRepository.deleteById(id);
    }
}
