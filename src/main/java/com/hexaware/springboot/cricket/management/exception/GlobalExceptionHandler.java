package com.hexaware.springboot.cricket.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PlayerNotFoundException.class)
	
	public ResponseEntity<String> playerNotFoundExceptionHandler(PlayerNotFoundException e){
		
		return new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_GATEWAY);
	}
}
