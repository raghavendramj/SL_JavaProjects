package com.simplilearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Product;
import com.simplilearn.repository.ProductRepository;
import com.simplilearn.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getProdcuts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByName(String productName) {
		return productRepository.findByName(productName);
	}
}
