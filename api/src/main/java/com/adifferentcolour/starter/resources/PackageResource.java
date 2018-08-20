package com.adifferentcolour.starter.resources;


import com.adifferentcolour.starter.domain.Package;
import com.adifferentcolour.starter.exceptions.PriceMismatchException;
import com.adifferentcolour.starter.exceptions.UnknownPackageException;
import com.adifferentcolour.starter.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/package")
public class PackageResource {

    private final PackageService packageService;

    @Autowired
    public PackageResource(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public Package get(@RequestParam("id") long id, @RequestParam(value = "currency", required = false) String currencyCode) throws UnknownPackageException {
        return packageService.getById(id, currencyCode);
    }

    @PutMapping
    public Package update(@RequestBody Package aPackage) throws PriceMismatchException, UnknownPackageException {
        return packageService.updatePackage(aPackage);
    }

    @GetMapping("/all")
    public List<Package> listAll() {
        return packageService.getAll();
    }

    @PostMapping
    public Package create(@RequestBody Package aPackage) throws PriceMismatchException {
        return packageService.savePackage(aPackage);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") long id) throws UnknownPackageException {
        packageService.delete(id);
    }

}
