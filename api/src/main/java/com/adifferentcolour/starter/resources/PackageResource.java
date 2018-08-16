package com.adifferentcolour.starter.resources;


import com.adifferentcolour.starter.domain.Bundle;
import com.adifferentcolour.starter.exceptions.PriceMismatchException;
import com.adifferentcolour.starter.exceptions.UnknownBundleException;
import com.adifferentcolour.starter.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/package")
public class PackageResource {

    private final PackageService packageService;

    @Autowired
    public PackageResource(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping("/get")
    public Bundle getPackage(@RequestParam("id") long id) {
        return packageService.getById(id);
    }

    @PutMapping("/update")
    public Bundle update(@RequestBody Bundle bundle) throws PriceMismatchException, UnknownBundleException {
        return packageService.updatePackage(bundle);
    }

    @GetMapping("/list-all")
    public List<Bundle> listAllPackages() {
        return packageService.getAll();
    }

    @PostMapping("/create")
    public Bundle create(@RequestBody Bundle bundle) throws PriceMismatchException {
        return packageService.createPackage(bundle);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam("id") long id) throws UnknownBundleException {
        packageService.delete(id);
    }

}
