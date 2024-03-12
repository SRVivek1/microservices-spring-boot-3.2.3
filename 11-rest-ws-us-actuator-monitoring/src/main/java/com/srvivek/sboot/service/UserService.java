/**
 * 
 */
package com.srvivek.sboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvivek.sboot.bean.User;
import com.srvivek.sboot.repository.UserRepository;

/**
 * 
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * Get all users.
	 * 
	 * @return
	 */
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	/**
	 * Get user for the given id.
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(Integer id) {
		return userRepository.findOne(id);
	}

	/**
	 * Save user.
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * Delete the user with given id.
	 * 
	 * @param id
	 * @return
	 */
	public User deleteById(Integer id) {
		return userRepository.deleteById(id);
	}
}
