/**
 * 
 */
package com.srvivek.sboot.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 */
@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handles all exceptions.
	 * 
	 * @param ex
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleGenericException(Exception ex, WebRequest request)
			throws Exception {
		ExceptionResponse er = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public final ResponseEntity<ExceptionResponse> authenticationException(Exception ex, WebRequest request)
			throws Exception {
		ExceptionResponse er = new ExceptionResponse(new Date(), "Unauthorized : " + ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Handles all UserNotFoundExceptions.
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(Exception e, WebRequest request) {

		ExceptionResponse er = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));

		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ExceptionResponse er = new ExceptionResponse(new Date(), "Validation error", ex.getAllErrors().toString());

		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}
}
