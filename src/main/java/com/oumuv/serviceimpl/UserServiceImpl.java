package com.oumuv.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumuv.dao.UserMapper;
import com.oumuv.entity.User;
import com.oumuv.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userDao;

	public User login(String username, String password) {
		User user = userDao.login(username, password);
		return user;
	}

	public String check(String username) {
		String user = userDao.check(username);
		return user;
	}

}
