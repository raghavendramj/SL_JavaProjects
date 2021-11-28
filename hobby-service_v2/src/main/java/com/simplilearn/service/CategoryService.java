package com.simplilearn.service;

import java.util.List;

import com.simplilearn.entity.Category;

public interface CategoryService {

	void save(Category category);

	List<Category> findAll();

	Category findById(long id);

	void delete(long id);
}
