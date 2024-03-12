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
 * API version using MIME type header {@code 'Accept'} received in request readers.
 * 
 * 
 */
@RestController
@RequestMapping(path = "/versioning")
public class MimeTypeVersioningController {

	/**
	 * Returns full name as String.
	 * @return
	 */
	@GetMapping(path = "/person/produces", produces = "application/vsr.company.app-v1+json")
	@Operation(description = "Returns person name.")
	public PersonV1 personV1() {
		return new PersonV1("Rahul Kumar");
	}

	/**
	 * Return {@link Name} instance.
	 * @return
	 */
	@GetMapping(path = "/person/produces", produces = "application/vsr.company.app-v2+json")
	@Operation(description = "Returns person namehttp://localhost:8080/versioning/person/param.")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Rahul", "Kumar"));
	}
}
