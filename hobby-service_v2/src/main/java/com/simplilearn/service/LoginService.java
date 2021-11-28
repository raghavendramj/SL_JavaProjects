package com.simplilearn.service;

import com.simplilearn.entity.LoginUser;


public interface LoginService {
	LoginUser login(String username, String password);
	boolean changePassword(String username, String newPassword);
}
