package com.example.materialmanagement.repository;

import com.example.materialmanagement.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product, Long> {
}
