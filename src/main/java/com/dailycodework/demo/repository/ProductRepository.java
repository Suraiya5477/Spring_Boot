package com.dailycodework.demo.repository;

import com.dailycodework.demo.model.Product;
// import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(Long category);
    List<Product> findByBrand(java.lang.String brand);
    List<Product> findByCategoryNameAndBrand(java.lang.String category, java.lang.String brand);

    List<Product> findByName(java.lang.String name);

    List<Product> findByBrandAndName(java.lang.String brand, java.lang.String name);

    Long countByBrandAndName(java.lang.String brand, java.lang.String name);

    // Spring Data JPA implements CRUD automatically
}