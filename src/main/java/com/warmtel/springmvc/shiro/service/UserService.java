package com.warmtel.springmvc.shiro.service;

import com.warmtel.springmvc.shiro.model.User;

public interface UserService {
	public User findByUsername(String userName);
}
