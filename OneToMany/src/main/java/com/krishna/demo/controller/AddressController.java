package com.krishna.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.demo.model.Address;
import com.krishna.demo.repository.AddressRepository;

@RestController
public class AddressController {
	 @Autowired
	    private AddressRepository addRepository;

	    @GetMapping("/address")
	    public List<Address> getEmployees(){
	        return addRepository.findAll();
	    }

}
