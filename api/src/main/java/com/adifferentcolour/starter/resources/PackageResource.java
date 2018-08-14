package com.adifferentcolour.starter.resources;


import com.adifferentcolour.starter.domain.ApplicationInfo;
import com.adifferentcolour.starter.domain.Package;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.adifferentcolour.starter.metrics.EventHandler.SendEvent;

@RestController
@RequestMapping("/api/v1/package")
public class PackageResource {

    @GetMapping("/get/:id")
    public Package getPackage(int id) {
        return null;
    }

    @GetMapping("/list-all")
    public List<Package> listAllPackages() {
        return null;
    }

    @PostMapping("create")
    public void createPackage(@RequestBody Package pack) {

    }

    @PostMapping("update")
    public void updatePackage(@RequestBody Package pack) {

    }

    @DeleteMapping("delete")
    public void deletePackge(int id) {

    }

}
