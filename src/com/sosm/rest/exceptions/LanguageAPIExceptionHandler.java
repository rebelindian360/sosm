package com.sosm.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LanguageAPIExceptionHandler {

	// Add an exception handler for CustomerNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<SosmErrorResponse> handleException(LanguageNotFoundException exc) {
		
		// create CustomerErrorResponse
		
		SosmErrorResponse error = new SosmErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// Add another exception handler ... to catch any exception (catch all)

	@ExceptionHandler
	public ResponseEntity<SosmErrorResponse> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		
		SosmErrorResponse error = new SosmErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
