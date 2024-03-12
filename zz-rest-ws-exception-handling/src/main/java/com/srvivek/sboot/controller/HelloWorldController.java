/**
 * 
 */
package com.srvivek.sboot.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
public class HelloWorldController {

	@Autowired
	MessageSource messageSource;

	@GetMapping("/status")
	public String greet() {

		return "Server is up !!";
	}
	
	@GetMapping("/greet")
	public String sayHello(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {

		return messageSource.getMessage("good.morning.message", null, locale);
	}

}
