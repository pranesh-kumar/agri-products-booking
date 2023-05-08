package com.krishna.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishna.demo.model.Product;
import com.krishna.demo.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	@PostConstruct
	public void initDB() {
		repository.saveAll(Stream.of(new Product(101, "Book", 499), new Product(102, "laptop", 78000))
				.collect(Collectors.toList()));
	}

	public List<Product> addProduct(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> findAllProducts() {
		return repository.findAll();
	}

}
