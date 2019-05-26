package com.example.materialmanagement.repository;

import com.example.materialmanagement.model.address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface addressRepository extends JpaRepository<address, Long> {
}
