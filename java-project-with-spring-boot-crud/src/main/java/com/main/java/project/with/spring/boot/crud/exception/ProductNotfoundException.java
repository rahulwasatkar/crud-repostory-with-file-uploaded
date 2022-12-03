package com.main.java.project.with.spring.boot.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotfoundException extends RuntimeException{
	public ProductNotfoundException(String msg) {
		super(msg);
	}
}
