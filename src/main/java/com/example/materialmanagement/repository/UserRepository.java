package com.example.materialmanagement.repository;

import com.example.materialmanagement.model.User;
import com.example.materialmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
