package com.krishna.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String username, String password) {
		if (username.equals("admin") && password.equals("123"))
			return true;
		else
			return false;
	}

}
