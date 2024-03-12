/**
 * 
 */
package com.srvivek.sboot.exception;

/**
 * 
 */
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5751084756713409704L;

	public UserNotFoundException(String msg) {
		super(msg);
	}
}
