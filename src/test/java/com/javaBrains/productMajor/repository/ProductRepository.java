package com.javaBrains.productMajor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaBrains.productMajor.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
