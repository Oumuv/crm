package com.oumuv.service;

import org.springframework.stereotype.Service;

import com.oumuv.entity.User;

public interface UserService {
	
	public User login(String username,String password);
	
	public String check(String username);
}
