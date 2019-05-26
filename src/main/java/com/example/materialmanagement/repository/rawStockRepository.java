package com.example.materialmanagement.repository;


import com.example.materialmanagement.model.rawStockProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface rawStockRepository extends JpaRepository<rawStockProduct, Long> {
}
