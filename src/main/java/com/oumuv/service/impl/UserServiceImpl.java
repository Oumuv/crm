package com.oumuv.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumuv.core.UserCardInfo;
import com.oumuv.dao.DepartmentEntityMapper;
import com.oumuv.dao.UserMapper;
import com.oumuv.entity.DepartmentEntity;
import com.oumuv.entity.User;
import com.oumuv.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userDao;
	@Autowired
	private DepartmentEntityMapper DepartmentDao;

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
		List<User> userListBySql;
		boolean nameflag = null!=uname&&!uname.equals("");
		boolean didflag = null!=did&&!did.equals("");
		if (!nameflag && !didflag) {// 如果都为空
			userListBySql = userDao.getUserListBySql(sql);
		} else {
			sql += " WHERE ";
			if (!nameflag) {// 如果name为空
				sql += " department_id=" + did;
			} else if (!didflag) {// 如果did为空
				sql += " name LIKE BINARY '%" + uname + "%'";
			} else {// 如果都不为空
				sql += " name LIKE BINARY '%" + uname + "%'";
				sql += " AND department_id=" + did;
			}
			userListBySql = userDao.getUserListBySql(sql);
		}
//		System.out.println(sql);

		return userListBySql;
	}


	public List<UserCardInfo> getUserCardListByUnameAndDid(String uname,
			Long did) {
		String sql = "SELECT * FROM user_info";
		List<UserCardInfo> users = new ArrayList<UserCardInfo>();
		List<User> userListBySql;//缓存用户list
		boolean nameflag = null!=uname&&!uname.equals("");
		boolean didflag = null!=did&&!did.equals("");
		if (!nameflag && !didflag) {// 如果都为空
			userListBySql = userDao.getUserListBySql(sql);
		} else {
			sql += " WHERE ";
			if (!nameflag) {// 如果name为空
				sql += " department_id=" + did;
			} else if (!didflag) {// 如果did为空
				sql += " name LIKE BINARY '%" + uname + "%'";
			} else {// 如果都不为空
				sql += " name LIKE BINARY '%" + uname + "%'";
				sql += " AND department_id=" + did;
			}
			userListBySql = userDao.getUserListBySql(sql);
		}
		List<DepartmentEntity> departmentEntitys = DepartmentDao.getAllDepartmentEntity();
		Map<Long, DepartmentEntity> dmap = new HashMap<Long, DepartmentEntity>();//缓存部门list
		for(DepartmentEntity d:departmentEntitys){
			dmap.put(d.getId(), d);
		}
		
		for(User u:userListBySql){
			UserCardInfo usercard = new UserCardInfo();
			usercard.setId(u.getId());
			usercard.setName(u.getName());
			usercard.setHimg(u.getHimg());
			usercard.setDepartmentEntity(dmap.get(u.getDepartmentId()));
			users.add(usercard);
		}
//		System.out.println(sql);
		return users;
	}

	public User getPersonInfo(User u) {
		User user = userDao.selectByPrimaryKey(u.getId());
		return user;
	}

	public int savePersonInfo(User u) {
		int selective = userDao.updateByPrimaryKeySelective(u);
		return selective;
	}

}
