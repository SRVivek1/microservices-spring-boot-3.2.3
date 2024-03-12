/**
 * 
 */
package com.srvivek.sboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srvivek.sboot.bean.Name;
import com.srvivek.sboot.bean.PersonV1;
import com.srvivek.sboot.bean.PersonV2;

import io.swagger.v3.oas.annotations.Operation;

/**
 * API version using parameter received in request readers.
 * 
 */
@RestController
@RequestMapping(path = "/versioning")
public class RequestHeaderParamVersioningController {

	/**
	 * Returns full name as String.
	 * @return
	 */
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	@Operation(description = "Returns person name.")
	public PersonV1 personV1() {
		return new PersonV1("Rahul Kumar");
	}

	/**
	 * Return {@link Name} instance.
	 * @return
	 */
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	@Operation(description = "Returns person namehttp://localhost:8080/versioning/person/param.")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Rahul", "Kumar"));
	}

}
