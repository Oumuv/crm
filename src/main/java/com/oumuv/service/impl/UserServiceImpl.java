package com.oumuv.service.impl;

import java.util.List;

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

	public List<User> getUserListByUnameAndDid(String uname, Long did) {
		String sql = "SELECT * FROM user_info";
//		if(null!=uname&&uname.equals("")){
//			sql += "WHERE name LIKE BINARY '"+uname+"'";
//		}
//		if(null!=did&&did.equals("")){
//			sql += "AND department_id="+did;
//		}
		System.out.println(sql);
		List<User> userListBySql = userDao.getUserListBySql(sql);
		return userListBySql;
	}

}
