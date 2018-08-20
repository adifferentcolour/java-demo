package com.adifferentcolour.starter.repositories;

import com.adifferentcolour.starter.domain.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BundleRepository extends JpaRepository<Bundle, Long> {
    public boolean existsById(Long id);
}
