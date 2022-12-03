package com.main.java.project.with.spring.boot.crud.exception;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductAlreadyExistExceptions.class)
public	ResponseEntity<String> productAlreadyExistExceptions(ProductAlreadyExistExceptions ex) {
		String msg = ex.getMessage();
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@ExceptionHandler(ProductNotfoundException.class)
	public ResponseEntity<String> productNotfoundException(ProductNotfoundException ex){
		String msg = ex.getMessage();
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String , Object> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, Object> map = new HashMap<>();
		map.put("Time", new Date());
		ex.getBindingResult().getFieldErrors().forEach(e->{
			map.put(e.getField(), e.getDefaultMessage());
		});
		return map;
		
	}
	
}
