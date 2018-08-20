package com.adifferentcolour.starter.services;

import com.adifferentcolour.starter.domain.Package;
import com.adifferentcolour.starter.domain.Product;
import com.adifferentcolour.starter.exceptions.PriceMismatchException;
import com.adifferentcolour.starter.exceptions.UnknownPackageException;
import com.adifferentcolour.starter.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageService {

    private final ProductService productService;
    private final PackageRepository packageRepository;
    private final CurrencyConverterService currencyConverterService;

    @Autowired
    public PackageService(ProductService productService,
                          PackageRepository packageRepository,
                          CurrencyConverterService currencyConverterService) {
        this.productService = productService;
        this.packageRepository = packageRepository;
        this.currencyConverterService = currencyConverterService;
    }


    public Package savePackage(Package aPackage) throws PriceMismatchException {
        productService.validateProductPrices(new ArrayList<>(aPackage.getProducts()));
        aPackage.setTotalPrice(aPackage.getProducts().stream().mapToInt(Product::getUsdPrice).sum());
        return packageRepository.saveAndFlush(aPackage);
    }

    public Package updatePackage(Package aPackage) throws PriceMismatchException, UnknownPackageException {
        if (!packageRepository.existsById(aPackage.getId())) {
            throw new UnknownPackageException();
        }
        return savePackage(aPackage);
    }

    public List<Package> getAll() {
        return packageRepository.findAll();
    }

    public Package getById(long id, String currencyCode) throws UnknownPackageException {
        Package aPackage = packageRepository.findById(id).orElseThrow(UnknownPackageException::new);

        if (currencyCode != null) {
            aPackage.setTotalPrice(aPackage.getProducts().stream()
                    .mapToInt(p -> currencyConverterService.convert(p.getUsdPrice(), currencyCode))
                    .sum());
        }

        return aPackage;
    }

    public void delete(long id) throws UnknownPackageException {
        if (!packageRepository.existsById(id)) {
            throw new UnknownPackageException();
        }

        packageRepository.deleteById(id);
    }
}
