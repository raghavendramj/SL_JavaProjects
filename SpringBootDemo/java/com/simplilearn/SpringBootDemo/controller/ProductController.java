package com.simplilearn.SpringBootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplilearn.SpringBootDemo.exceptions.ProductNotFoundException;

@Controller
public class ProductController {

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getProduct(@PathVariable("id") String id) {

		if (id.contentEquals("0")) {
			throw new ProductNotFoundException();
		}
		return "Product was found";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	@ResponseBody
	public String helloSpringBoot() {
		return "Hey Welcome to Spring Boot World!";
	}
}
