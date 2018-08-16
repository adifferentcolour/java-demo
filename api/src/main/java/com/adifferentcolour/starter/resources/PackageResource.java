package com.adifferentcolour.starter.resources;


import com.adifferentcolour.starter.domain.Bundle;
import com.adifferentcolour.starter.exceptions.PriceMismatchException;
import com.adifferentcolour.starter.exceptions.UnknownBundleException;
import com.adifferentcolour.starter.services.BundleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/package")
public class PackageResource {

    private final BundleService bundleService;

    @Autowired
    public PackageResource(BundleService bundleService) {
        this.bundleService = bundleService;
    }

    @GetMapping("/get")
    public Bundle getPackage(@RequestParam("id") long id) {
        return bundleService.getById(id);
    }

    @PutMapping("/update")
    public Bundle update(@RequestBody Bundle bundle) throws PriceMismatchException, UnknownBundleException {
        return bundleService.updatePackage(bundle);
    }

    @GetMapping("/list-all")
    public List<Bundle> listAllPackages() {
        return bundleService.getAll();
    }

    @PostMapping("/create")
    public Bundle create(@RequestBody Bundle bundle) throws PriceMismatchException {
        return bundleService.savePackage(bundle);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam("id") long id) throws UnknownBundleException {
        bundleService.delete(id);
    }

}
