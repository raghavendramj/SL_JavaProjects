package com.simplilearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simplilearn.model.User;

@Service
public interface UserService {

	public List<User> findAll();

	public User findById(int userId);

	public void save(User newUser);
	
	public void delete(int userId);

	public List<User> searchBy(String firstName, String email);
}
