package com.simplilearn.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.LoginUser;
import com.simplilearn.repository.LoginRepository;
import com.simplilearn.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public LoginUser login(String username, String password) {
		LoginUser user = loginRepository.findByUsernameAndPassword(username, password);
		System.out.println("User found : " + user);
		return user;
	}

	public boolean changePassword(String username, String newPassword) {
		LoginUser user = loginRepository.findByUsername(username);
		if (Objects.nonNull(user)) {
			loginRepository.changePassword(newPassword, user.getId());
			System.out.println("User " + user.getUsername() + " has successfuly changed the password");
			return true;
		} else {
			System.out.println("Unable to change the password!");
			return false;
		}

	}

}
