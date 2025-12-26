package com.dailycodework.demo.repository;

import com.dailycodework.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    
    // Spring Data JPA implements CRUD automatically
}