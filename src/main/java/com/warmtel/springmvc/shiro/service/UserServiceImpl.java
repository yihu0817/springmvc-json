package com.warmtel.springmvc.shiro.service;

import com.warmtel.springmvc.shiro.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public User findByUsername(String userName) {
		User user = new User(1,"admin","123");
		return user;
	}

}
