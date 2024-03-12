/**
 * 
 */
package com.srvivek.sboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.srvivek.sboot.bean.HelloWorldBean;

/**
 * Hello world greeting controller
 */
@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean.");
	}
	
	@GetMapping(path = "/hello-world/{user}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable(name = "user") String name) {
		return new HelloWorldBean(String.format("Hello Mr. %s", name));
	}

}
