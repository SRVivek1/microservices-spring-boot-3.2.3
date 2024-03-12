/**
 * 
 */
package com.srvivek.sboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8842834815232190350L;

	/**
	 * @param message
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

}
