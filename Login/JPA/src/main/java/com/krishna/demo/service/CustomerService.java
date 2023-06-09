package com.krishna.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krishna.demo.model.Customer;
import com.krishna.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repository;

	public String addCustomer(Customer customer) {
		repository.save(customer);
		return "Added";
	}

	public List<Customer> getCustomer() {
		return repository.findAll();
	}

	public Optional<Customer> getCustomerById(int id) {
		return repository.findById(id);
	}

	public String updateCustomer(Customer customer) {
		repository.save(customer);
		return "Updated";
	}

	public String deleteCustomerById(int id) {
		repository.deleteById(id);
		return "Customer deleted";

	}
}
