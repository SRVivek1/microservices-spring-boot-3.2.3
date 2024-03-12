/**
 * 
 */
package com.srvivek.sboot.controller;

import java.net.URI;
import java.util.List;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.srvivek.sboot.bean.User;
import com.srvivek.sboot.exception.UserNotFoundException;
import com.srvivek.sboot.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

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
	@Operation(summary = "Returns all the users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	/**
	 * Get one user.
	 * 
	 * HATEOAS supported API.
	 * 
	 * @return
	 */
	@GetMapping(path = "/users/v2/{id}")
	@Operation(summary = "Returns the users with given userId, with rel - all-users.")
	public EntityModel<User> getUserV2(@PathVariable Integer id) {

		final User user = userService.getUser(id);
		final EntityModel<User> entityModel = EntityModel.of(user);

		Link linktTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers())
				.withRel("all-users");

		entityModel.add(linktTo);

		return entityModel;
	}

	/**
	 * Get one user
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/users/{id}")
	@Operation(summary = "Returns the users with given userId.", deprecated = true)
	public User getUser(@PathVariable Integer id) {
		User user = userService.getUser(id);

		if (user == null) {
			throw new UserNotFoundException(String.format("No user found with id : %s", id));
		}

		return user;
	}

	/**
	 * Save one user. Sent back the created user object.
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/users")
	@Operation(summary = "Saves the given user in DB.", deprecated = true)
	public ResponseEntity<User> save(@Valid @RequestBody User user) {
		User u = userService.save(user);

		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.id()).toUri();

		return ResponseEntity.created(loc).body(u);

	}

	/**
	 * Stores the give user. Created user info not sent back to requester.
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/users/v2")
	@Operation(summary = "Saves the given user in DB.")
	public ResponseEntity<Object> save_v2(@RequestBody User user) {

		User u = userService.save(user);

		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.id()).toUri();

		return ResponseEntity.created(loc).build();
	}

	/**
	 * Delete user. If user not found sent success with HTTP Status 204.
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping(path = "/users/{id}")
	@Operation(summary = "Delete the user with given userId.", deprecated = true)
	@RouterOperation(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> deleteById(@PathVariable(name = "id") Integer userId) {
		User user = userService.deleteById(userId);

		if (user == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	/**
	 * Delete user. If user not found {@link UserNotFoundException} exception.
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping(path = "/users/v2/{id}")
	@Operation(summary = "Delete the user with given userId.")
	public ResponseEntity<User> deleteByIdV2(@PathVariable(name = "id") Integer userId) {

		User user = userService.deleteById(userId);

		if (user == null) {
			throw new UserNotFoundException(String.format("No user found with id : %s", userId));
		}

		return ResponseEntity.ok(user);
	}
}
