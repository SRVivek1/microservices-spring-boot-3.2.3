package com.srvivek.sboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.srvivek.sboot.bean.Post;
import com.srvivek.sboot.bean.User;
import com.srvivek.sboot.exception.UserNotFoundException;
import com.srvivek.sboot.service.UserJpaService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * 
 */
@RestController
@RequestMapping(path = "/jpa")
public class UserJpaController {

	@Autowired
	UserJpaService userJpaService;

	/**
	 * Get all users
	 * 
	 * @return
	 */
	@GetMapping(path = "/users")
	@Operation(summary = "Returns all the users")
	public List<User> getUsers() {
		return userJpaService.getUsers();
	}

	/**
	 * Get one user.
	 * 
	 * HATEOAS supported API.
	 * 
	 * @return
	 */
	@GetMapping(path = "/users/{id}")
	@Operation(summary = "Returns the users with given userId, with rel - all-users.")
	public EntityModel<User> getUser(@PathVariable Integer id) {

		final User user = userJpaService.getUser(id);

		if (user == null) {
			throw new UserNotFoundException(String.format("No user found with id : %s", id));
		}

		final EntityModel<User> entityModel = EntityModel.of(user);

		Link linktTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers())
				.withRel("all-users");

		entityModel.add(linktTo);

		return entityModel;
	}

	/**
	 * Stores the give user. Created user info not sent back to requester.
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/users")
	@Operation(summary = "Saves the given user in DB.")
	public ResponseEntity<Object> save(@RequestBody User user) {

		User u = userJpaService.save(user);

		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();

		return ResponseEntity.created(loc).build();
	}

	/**
	 * Delete user. If user not found {@link UserNotFoundException} exception.
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping(path = "/users/{id}")
	@Operation(summary = "Delete the user with given userId.")
	public ResponseEntity<User> deleteById(@PathVariable(name = "id") Integer userId) {

		User user = userJpaService.deleteById(userId);

		if (user == null) {
			throw new UserNotFoundException(String.format("No user found with id : %s", userId));
		}

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	/*
	 * Start : Post Controllers
	 */

	/**
	 * Retrieve all posts for a user : GET /user/{id}/posts
	 */
	@Operation(summary = "Get all the posts of the user")
	@GetMapping(path = "/user/{id}/posts")
	public ResponseEntity<List<Post>> getPosts(@PathVariable(name = "id") String userId) {

		// get the user
		final User user = userJpaService.getUser(userId);

		return ResponseEntity.status(HttpStatus.OK).body(user.getPost());
	}

	/**
	 * Create a post for a user : POST /user/{id}/posts}
	 */
	@Operation(summary = "Store the post for the user.")
	@PostMapping(path = "/user/{id}/posts")
	public ResponseEntity<Post> savePost(@PathVariable(name = "id") Integer userId, @RequestBody Post post) {

		post = userJpaService.savePost(userId, post);

		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(loc).body(post);
	}

	/**
	 * Retrieve details of a post : GET /user/{id}/posts}/{post_id}
	 */
	@Operation(summary = "Get the post with post id for given user.")
	@GetMapping(path = "/user/{id}/posts/{post_id}")
	public ResponseEntity<Post> getPost(@PathVariable(name = "id") Integer userId,
			@PathVariable(name = "post_id") Integer postId) {

		Post post = userJpaService.getPost(userId, postId);

		return ResponseEntity.ok(post);
	}

	/**
	 * Remove post with given id
	 */
	@Operation(summary = "Delete post for the given user.")
	@DeleteMapping(path = "user/{id}/posts/{post_id}")
	public ResponseEntity<Post> deletePost(@PathVariable(name = "id") Integer userId, @PathVariable(name = "post_id") Integer postId) {

		Post post = userJpaService.deletePostById(userId, postId);
		
		return ResponseEntity.ok(post);
	}

}
