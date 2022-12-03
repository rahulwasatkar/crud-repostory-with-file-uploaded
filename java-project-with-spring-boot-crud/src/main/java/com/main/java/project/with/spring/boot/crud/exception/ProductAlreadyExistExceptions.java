package com.main.java.project.with.spring.boot.crud.exception;

public class ProductAlreadyExistExceptions extends RuntimeException {
	
	public ProductAlreadyExistExceptions(String msg){
		super(msg);
	}
}
