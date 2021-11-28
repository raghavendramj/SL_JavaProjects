package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}