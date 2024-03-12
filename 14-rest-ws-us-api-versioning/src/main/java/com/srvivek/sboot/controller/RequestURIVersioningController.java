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
 * 
 */
@RestController
@RequestMapping(path = "/versioning")
public class RequestURIVersioningController {

	/**
	 * Returns full name as String.
	 * @return
	 */
	@GetMapping(path = "v1/person")
	@Operation(description = "Returns person name v1.", deprecated = true)
	public PersonV1 personV1() {
		return new PersonV1("Rahul Kumar");
	}

	/**
	 * Return {@link Name} instance.
	 * @return
	 */
	@GetMapping(path = "v2/person")
	@Operation(description = "Returns person name v2.")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Rahul", "Kumar"));
	}

}
