/**
 * 
 */
package com.srvivek.sboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.srvivek.sboot.bean.User;
import com.srvivek.sboot.exception.UserNotFoundException;
import com.srvivek.sboot.service.UserService;

/**
 * 
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * Get all users
	 * 
	 * @return
	 */
	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	/**
	 * Get one user
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> getUser(@PathVariable Integer id) {
		User user = userService.getUser(id);

		if (user == null) {
			throw new UserNotFoundException(String.format("No User found with Id : %s", id));
		}

		EntityModel<User> model = EntityModel.of(user);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers()).withRel("all-users");
		model.add(link);
		
		return model;
	}

	/**
	 * Save one user.
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/users")
	public ResponseEntity<User> save(@RequestBody User user) {
		User u = userService.save(user);

		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.id()).toUri();
		return ResponseEntity.created(loc).body(u);

	}

}
