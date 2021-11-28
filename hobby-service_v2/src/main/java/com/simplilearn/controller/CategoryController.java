package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Category;
import com.simplilearn.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryService.findAll();
	}

	@GetMapping("/categories/{id}")
	public Category getAllCategories(@PathVariable("id") long id) {
		return categoryService.findById(id);
	}

	@PostMapping("/categories")
	public void saveCategory(@RequestBody Category newCategory) {
		categoryService.save(newCategory);
	}
	
	@DeleteMapping("/categories/{id}")
	public void deleteCategory(@PathVariable("id") long id) {
		categoryService.delete(id);
	}

}
