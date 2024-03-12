/**
 * 
 */
package com.srvivek.sboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvivek.sboot.bean.User;
import com.srvivek.sboot.repository.UserJpaRepository;

/**
 * 
 */
@Service
public class UserJpaService {

	@Autowired
	UserJpaRepository userJpaRepository;

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
	public User getUser(Integer id) {
		Optional<User> res = userJpaRepository.findById(id);
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

		User user = this.getUser(id);
		if (user != null) {
			return user;
		}
		return null;
	}
}
