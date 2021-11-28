package com.simplilearn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Category;
import com.simplilearn.repository.CategoryRepository;
import com.simplilearn.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);

		if (optionalCategory.isPresent())
			return optionalCategory.get();

		return null;
	}

	@Override
	public void delete(long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);

		if (optionalCategory.isPresent())
			categoryRepository.delete(optionalCategory.get());
	}
}
