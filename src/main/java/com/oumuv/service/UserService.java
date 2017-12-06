package com.oumuv.service;

import java.util.List;

import com.oumuv.core.info.UserCardInfo;
import com.oumuv.entity.User;

public interface UserService {
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
	/**
	 * 用户名验证
	 * @param username
	 * @return
	 */
	public String check(String username);
	/**
	 * 用户名模糊查询
	 * 部门查询
	 * @param uname
	 * @param did
	 * @return
	 */
	public List<User> getUserListByUnameAndDid(String uname,Long did);
	public List<UserCardInfo> getUserCardListByUnameAndDid(String uname,Long did);
	
	/**
	 * 获取个人信息
	 */
	public User getPersonInfo(User u);
	
	/**
	 * 保存个人信息
	 * @param u
	 * @return
	 */
	public int savePersonInfo(User u);
	
	/**
	 * 更新用户usercard信息
	 * @param user user实体类，包含内容有部门ID，角色ID
	 * @param rids 角色ID列
	 * @return
	 */
	public int updataUsercardInfo(User user,List<Long> rids);
	/**
	 * 添加用户usercard
	 * @param user
	 * @param rids
	 * @return
	 */
	public int addUsercardInfo(User user);
}
