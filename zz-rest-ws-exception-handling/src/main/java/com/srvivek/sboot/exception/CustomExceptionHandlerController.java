/**
 * 
 */
package com.srvivek.sboot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 */
@RestControllerAdvice
@RestController
public class CustomExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomBaseException> handleAllExceptions(Exception e, WebRequest request) {
		return new ResponseEntity<CustomBaseException>(
				new CustomBaseException(new Date(), e.getMessage(), request.getDescription(false)),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomBaseException> handleUserNotFoundException(Exception e, WebRequest wr) {
		return new ResponseEntity<CustomBaseException>(
				new CustomBaseException(new Date(), e.getMessage(), wr.getDescription(false)), HttpStatus.NOT_FOUND);
	}
}
