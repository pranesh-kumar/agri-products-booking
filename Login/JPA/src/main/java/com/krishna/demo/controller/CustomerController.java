package com.krishna.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.demo.model.Customer;
import com.krishna.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("")
	public String create(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}

	@GetMapping("")
	public List<Customer> read() {
		return service.getCustomer();
	}

	@GetMapping("/{id}")
	public Optional<Customer> readById(@PathVariable int id) {
		return service.getCustomerById(id);
	}

	@PutMapping("")
	public String update(@RequestBody Customer customer) {
		return service.updateCustomer(customer);

	}

	@DeleteMapping("")
	public String delete(@RequestParam int id) {
		return service.deleteCustomerById(id);
	}

}
