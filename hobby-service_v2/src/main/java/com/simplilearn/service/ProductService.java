package com.simplilearn.service;

import java.util.List;

import com.simplilearn.entity.Product;

public interface ProductService {
	void save(Product product);
	List<Product> getProdcuts();
	List<Product> findByName(String name);
}
