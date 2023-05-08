package com.krishna.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.demo.model.Employee;
import com.krishna.demo.repository.EmployeeRepository;
import com.krishna.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@Autowired
	EmployeeRepository repository;

	@PostMapping("")
	public Employee addEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}

	@GetMapping("")
	public List<Employee> getEmployee() {
		return repository.findAll();
	}

	@GetMapping("/count")
	public long getEmployeeCount() {
		return repository.count();
	}

	@GetMapping("/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name) {
		return repository.findByName(name);
	}

	@GetMapping("/idandstatus/{id}/{name}")
	public List<Employee> getEmployeeByNameOrStatus(@PathVariable int id, @PathVariable String name) {
		return repository.findByIdOrName(id, name);
	}

	@GetMapping("/status/{status}")
	public List<Employee> getActiveEmployees(@PathVariable String status) {
		return repository.findByStatus(status);
	}

	@GetMapping("/nameandstatus/{name}/{status}")
	public List<Employee> getEmployeeByNameAndStatus(@PathVariable String name, @PathVariable String status) {
		return repository.findByNameAndStatus(name, status);
	}

	@GetMapping("/nameprefix/{start}")
	public List<Employee> findByNameStartsWith(@PathVariable("start") String start) {
		return repository.findByNameStartingWith(start);
	}

	@GetMapping("/namesuffix/{end}")
	public List<Employee> ffindByNameEndsWith(@PathVariable("end") String end) {
		return repository.findByNameEndingWith(end);
	}
	
	@GetMapping("/getallusers/{name}")
	 public List<Employee> getAllEmployees (){
		 return repository.getAllEmployees();
	 }
	@GetMapping("/getallemployees/{name}/{status}")
	public List<Employee> getallemployeeList(@PathVariable String name, @PathVariable String status) {
		return repository.getAllEmployees(name, status);
	}

	@PutMapping(value = "/getallusers/{status}/{id}")
	public String updateEmployee(@PathVariable("status") String status, @PathVariable int id) {
		String res = "";
		int result = repository.updateEmployee(status, id);
		if (result > 0) {
			res = "Status updated" + result;
		} else {
			res = "Not updated" + result;
		}
		return res;
	}
	@DeleteMapping("/remove/{id}")
	public int deleteEmployee( @PathVariable int id) {
		return repository.deleteEmployee(id);
	}
}
