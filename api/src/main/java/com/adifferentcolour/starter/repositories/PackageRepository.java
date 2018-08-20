package com.adifferentcolour.starter.repositories;

import com.adifferentcolour.starter.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Long> {
    public boolean existsById(Long id);
}
