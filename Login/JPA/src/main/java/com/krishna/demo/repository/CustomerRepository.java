package com.krishna.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishna.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	

}
