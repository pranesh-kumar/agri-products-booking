package com.krishna.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	Logger logger = LoggerFactory.getLogger(AppController.class);

	@GetMapping("/")
	public String getMessage() {
		logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
		return "Log message in console";
	}
	@GetMapping("/customer")
	public String getCustomer() {
		logger.info("[executing getCustomer() method..] info message");
		return "Customer details";
	}
}