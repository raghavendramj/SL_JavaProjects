package com.simplilearn.SpringBootDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simplilearn.SpringBootDemo.exceptions.ProductNotFoundException;

@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception) {
		return new ResponseEntity<>("ERROR !!! ::: Product Not Found, please re-enter the product!", HttpStatus.NOT_FOUND);
	}

}
