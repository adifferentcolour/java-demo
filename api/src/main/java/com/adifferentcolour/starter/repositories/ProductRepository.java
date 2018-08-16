package com.adifferentcolour.starter.repositories;

import com.adifferentcolour.starter.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
