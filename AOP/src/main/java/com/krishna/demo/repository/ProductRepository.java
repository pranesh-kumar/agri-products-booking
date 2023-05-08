package com.krishna.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
