package com.krishna.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.demo.model.Employee;
import com.krishna.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
    private EmployeeRepository empRepository;

    @PostMapping("/employee")
    public ResponseEntity<String> saveEmployees(@RequestBody Employee empData) {
        empRepository.save(empData);
        return ResponseEntity.ok("Data saved");
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return empRepository.findAll();
    }

}
