/**
 * 
 */
package com.srvivek.sboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvivek.sboot.bean.Post;
import com.srvivek.sboot.bean.User;
import com.srvivek.sboot.exception.PostNotFoundException;
import com.srvivek.sboot.exception.UserNotFoundException;
import com.srvivek.sboot.repository.PostJpaRepository;
import com.srvivek.sboot.repository.UserJpaRepository;

/**
 * 
 */
@Service
public class UserJpaService {

	@Autowired
	UserJpaRepository userJpaRepository;

	@Autowired
	PostJpaRepository postJpaRepository;

	/**
	 * Get all users.
	 * 
	 * @return
	 */
	public List<User> getUsers() {
		return userJpaRepository.findAll();
	}

	/**
	 * Get user for the given id.
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(String id) {

		Integer userId = null;
		try {
			userId = Integer.parseInt(id);
		} catch (Exception e) {
			throw new UserNotFoundException(String.format("User not found. ID : %s", id));
		}

		return getUser(userId);
	}

	/**
	 * Get user for the given id.
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(Integer id) {
		Optional<User> res = userJpaRepository.findById(id);

		if (res.isEmpty()) {
			throw new UserNotFoundException(String.format("User not found. ID : %s", id));
		}

		return res.isPresent() ? res.get() : null;
	}

	/**
	 * Save user.
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user) {
		return userJpaRepository.save(user);
	}

	/**
	 * Delete the user with given id.
	 * 
	 * @param id
	 * @return
	 */
	public User deleteById(Integer id) {

		// TODO: Refactor to delete cascade with posts table
		User user = this.getUser(id);

		if (user != null) {
			userJpaRepository.deleteById(user.getId());
			return user;
		}
		return null;
	}

	/**
	 * Save posts for the user id.
	 * 
	 * @param userId
	 * @param post
	 */
	public Post savePost(Integer userId, Post post) {

		User user = getUser(userId);
		post.setUser(user);

		postJpaRepository.save(post);

		return post;
	}

	/**
	 * Get the post with post_id for given userId.
	 * 
	 * @param userId
	 * @param postId
	 * @return
	 */
	public Post getPost(Integer userId, Integer postId) {

		Optional<Post> res = postJpaRepository.findById(postId);

		if (res.isEmpty()) {
			throw new PostNotFoundException(
					String.format("Post not found for user id : %s, post id : %s", userId, postId));
		}

		if (!res.get().getUser().getId().equals(userId)) {
			throw new PostNotFoundException(String.format("Post not found for post id : %s", postId));
		}

		return res.get();
	}

	/**
	 * Delete the post for the given user.
	 * 
	 * @param userId
	 * @param postId
	 * @return
	 */
	public Post deletePostById(Integer userId, Integer postId) {

		Optional<Post> post = postJpaRepository.findById(postId);

		if (post.isEmpty()) {
			return new Post();
		}

		if (!post.get().getUser().getId().equals(userId)) {
			return new Post();
		}

		postJpaRepository.delete(post.get());

		return post.get();
	}
}
