package com.srvivek.sboot.exception;

/**
 * 
 */
public class PostNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4882353498402085398L;

	/**
	 * @param message
	 */
	public PostNotFoundException(String message) {
		super(message);
	}

	
}
