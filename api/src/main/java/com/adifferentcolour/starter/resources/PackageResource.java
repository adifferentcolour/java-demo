package com.adifferentcolour.starter.resources;


import com.adifferentcolour.starter.domain.Bundle;
import com.adifferentcolour.starter.exceptions.PriceMismatchException;
import com.adifferentcolour.starter.exceptions.UnknownBundleException;
import com.adifferentcolour.starter.services.BundleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/package")
public class PackageResource {

    private final BundleService bundleService;

    @Autowired
    public PackageResource(BundleService bundleService) {
        this.bundleService = bundleService;
    }

    @GetMapping
    public Bundle get(@RequestParam("id") long id) {
        return bundleService.getById(id);
    }

    @PutMapping
    public Bundle update(@RequestBody Bundle bundle) throws PriceMismatchException, UnknownBundleException {
        return bundleService.updatePackage(bundle);
    }

    @GetMapping("/all")
    public List<Bundle> listAll() {
        return bundleService.getAll();
    }

    @PostMapping
    public Bundle create(@RequestBody Bundle bundle) throws PriceMismatchException {
        return bundleService.savePackage(bundle);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") long id) throws UnknownBundleException {
        bundleService.delete(id);
    }

}
