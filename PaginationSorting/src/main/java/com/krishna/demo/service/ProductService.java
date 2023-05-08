package com.krishna.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.krishna.demo.model.Product;
import com.krishna.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	public String addProduct(Product product) {
		repository.save(product);
		return "Added";
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	// sorting
	public List<Product> getProductsSorted(String field) {
		return repository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	// pagination
	public List<Product> getProductsWithPagination(int offset, int pageSize) {
		Page<Product> page = repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	
	//sorting and pagination
	public List<Product> getProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
		Pageable paging = PageRequest.of(offset, pageSize, Sort.by(field));
		Page<Product> page = repository.findAll(paging);
		return page.getContent();
	}
}
