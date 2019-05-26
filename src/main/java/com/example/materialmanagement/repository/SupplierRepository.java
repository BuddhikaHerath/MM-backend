package com.example.materialmanagement.repository;

import com.example.materialmanagement.model.Supplier;
import com.example.materialmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
