package com.oumuv.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oumuv.core.info.UserCardInfo;
import com.oumuv.dao.DepartmentEntityMapper;
import com.oumuv.dao.RoleEntityMapper;
import com.oumuv.dao.UserMapper;
import com.oumuv.entity.DepartmentEntity;
import com.oumuv.entity.RoleEntity;
import com.oumuv.entity.User;
import com.oumuv.service.UserService;
import com.oumuv.utils.MD5Util;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userDao;
	@Autowired
	private DepartmentEntityMapper DepartmentDao;
	@Autowired
	private RoleEntityMapper roleDao;

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
		List<User> userListBySql = new ArrayList<User>();
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

	@Transactional
	public int updataUsercardInfo(User user, List<Long> rids) {
		int j = userDao.updateByPrimaryKeySelective(user);
		List<RoleEntity> oldRoles = roleDao.findRoleByUid(user.getId());
		List<Long> odlRoleId = new ArrayList<Long>();
		for(RoleEntity r:oldRoles){
			odlRoleId.add(r.getRoleId());
		}
		if(null==rids){
			rids = new ArrayList<Long>();
		}
			List<Long> delId = setDifferenceSet(odlRoleId,rids);
			List<Long> addId = setDifferenceSet(rids,odlRoleId);
			if(null!=delId&&delId.size()>0){
				String Sql = jointSql2(delId);
				int i = userDao.delRoles(user.getId().toString(), Sql);
				System.out.println("删除用户角色"+i+"个");
			}
			if(null!=addId&&addId.size()>0){
				String jointSql = jointSql(user.getId(),addId);
				int i = userDao.addRoles(user.getId().toString(),jointSql);
				System.out.println("添加用户角色"+i+"个");
			}
		return j;
	}
	@Transactional
	public int addUsercardInfo(User user) {
		user.setPassword(MD5Util.GetMD5Code("123456"));//默认密码123456
		int j = userDao.insertSelective(user);
		return j;
	}
	
	/**
	 * 集合差集运算
	 * @return
	 */
	private List<Long> setDifferenceSet(List<Long> list1,List<Long> list2){
		List<Long> list = new ArrayList<Long>();
		list.addAll(list1);
		list.removeAll(list2);
		return list;
	}
	/**
	 * 拼接sql
	 * 格式"({@link rid},{@link ids}),({@link rid},{@link ids})"
	 * @param rid
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unused")
	private String jointSql(Long rid,List<Long> ids){
		String sql = "";
		for(Long id:ids){
			sql += "("+rid+","+id+"),";
		}
		return sql.substring(0, sql.length()-1);
	}
	/**
	 * 拼接sql
	 * 格式({@link id},{@link id})
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unused")
	private String jointSql2(List<Long> ids){
		String sql = "(";
		for(Long id:ids){
			sql += id+",";
		}
		return sql.substring(0, sql.length()-1)+")";
	}

}
