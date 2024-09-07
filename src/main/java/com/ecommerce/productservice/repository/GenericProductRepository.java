package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.models.GenericProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenericProductRepository extends JpaRepository<GenericProduct, Long> {
    List<GenericProduct> findByNameContainingIgnoreCase(String name);
    Page<GenericProduct> findByNameContainingIgnoreCase(String name, Pageable pageable);
}