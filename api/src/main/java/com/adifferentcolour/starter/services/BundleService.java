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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BundleService {

    private final ProductService productService;
    private final BundleRepository bundleRepository;
    private final CurrencyConverterService currencyConverterService;

    @Autowired
    public BundleService(ProductService productService,
                         BundleRepository bundleRepository,
                         CurrencyConverterService currencyConverterService) {
        this.productService = productService;
        this.bundleRepository = bundleRepository;
        this.currencyConverterService = currencyConverterService;
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

    public Bundle getById(long id, String currencyCode) throws UnknownBundleException {
        Bundle bundle = bundleRepository.findById(id).orElseThrow(UnknownBundleException::new);

        if (currencyCode != null) {
            bundle.setTotalPrice(bundle.getProducts().stream()
                    .mapToInt(p -> currencyConverterService.convert(p.getUsdPrice(), currencyCode))
                    .sum());
        }

        return bundle;
    }

    public void delete(long id) throws UnknownBundleException {
        if (!bundleRepository.existsById(id)) {
            throw new UnknownBundleException();
        }

        bundleRepository.deleteById(id);
    }
}
