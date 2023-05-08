package com.krishna.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.demo.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService service;

	@RequestMapping("/login")
	public String validateUser(@RequestParam String username, @RequestParam String password) {
		if (service.validateUser(username, password))
			return "Valid user";
		else
			return "Invalid user";
	}

}
