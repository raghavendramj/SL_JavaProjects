package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Product;
import com.simplilearn.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService prodService;

	@GetMapping("/products")
	public List<Product> listProducts() {
		return prodService.getProdcuts();
	}

	@GetMapping("/products/{name}")
	public List<Product> searchProductByName(@PathVariable("name") String productName) {
		return prodService.findByName(productName);
	}

	@PostMapping("/products")
	public void addProduct(@RequestBody Product newProduct) {
		prodService.save(newProduct);
	}
}
