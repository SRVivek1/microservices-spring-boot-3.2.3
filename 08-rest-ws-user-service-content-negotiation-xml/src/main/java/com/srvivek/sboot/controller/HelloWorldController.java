/**
 * 
 */
package com.srvivek.sboot.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.srvivek.sboot.bean.HelloWorldBean;

/**
 * Hello world greeting controller
 */
@RestController
public class HelloWorldController {

	@Autowired
	MessageSource messageSource;

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

	/**
	 * Support i18n messaging
	 * @param locale
	 * @return
	 */
	@GetMapping(path = "/hello-world-bean/i18n")
	public HelloWorldBean helloWorldBeanI18n(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		String msg = messageSource.getMessage("good.morning.message", null, locale);
		return new HelloWorldBean(msg);
	}

	@GetMapping(path = "/hello-world/i18n/{user}")
	public HelloWorldBean helloWorldPathVariableI18n(@PathVariable(name = "user") String name) {
		return new HelloWorldBean(String.format("Hello Mr. %s", name));
	}
}
