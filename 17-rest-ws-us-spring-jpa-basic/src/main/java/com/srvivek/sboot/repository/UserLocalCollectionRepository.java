package com.srvivek.sboot.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.srvivek.sboot.bean.User;

/**
 * User DAO service.
 */
@Repository
public class UserLocalCollectionRepository {

	private static List<User> users = new ArrayList<>();
	private static int counter = 1000;

	static {
		// dummy users
		users.add(new User(counter++, "Rahul", new Date()));
		users.add(new User(counter++, "Vivek", new Date()));
		users.add(new User(counter++, "Sahil", new Date()));
		users.add(new User(counter++, "Bbalu", new Date()));
	}

	/**
	 * Get all users.
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return users;
	}

	/**
	 * Get the user with given user id.
	 * 
	 * @param id
	 * @return
	 */
	public User findOne(Integer id) {
		Optional<User> res = users.stream().filter(u -> u.getId().equals(id)).findFirst();

		if (res.isEmpty()) {
			return null;
		}

		return res.get();
	}

	/**
	 * Save the user.
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user) {
		if (user.getId() == null) {
			user = new User(counter++, user.getName(), user.getDob());
		}
		users.add(user);

		return user;
	}

	/**
	 * Remove user with given id.
	 * 
	 * @param id
	 * @return
	 */
	public User deleteById(Integer id) {
		User deletedUser = null;

		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.getId().equals(id)) {
				deletedUser = u;
				users.remove(i);
				break;
			}
		}
		return deletedUser;
	}
}
