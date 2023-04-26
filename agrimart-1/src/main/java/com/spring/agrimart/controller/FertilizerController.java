package com.spring.agrimart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.agrimart.model.FertilizerModel;
import com.spring.agrimart.repository.FertilizerRepository;

@RestController
public class FertilizerController {
	@Autowired
	FertilizerRepository fr;
	@GetMapping("/crud")
	public List<FertilizerModel> getAllDetails(){
		return fr.findAll();
	}
	@GetMapping("/crud/{id}")
	public FertilizerModel getDetailsById(@PathVariable int id) {
		return fr.findById(id).orElse(null);
	}
	@DeleteMapping("/crud/{id}")
	public String deleteById(@PathVariable int id) {
		fr.deleteById(id);
		return "deleted";
	}
	@PostMapping("/save")
	public String saveAll(@RequestBody FertilizerModel id)
	{
		fr.save(id);
		return "saved";
	}
	@PutMapping("/put")
	public FertilizerModel updateId(@RequestBody FertilizerModel c)
	{
		return fr.save(c);
	}
	

}
