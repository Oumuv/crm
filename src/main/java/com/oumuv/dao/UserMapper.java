package com.oumuv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oumuv.entity.User;

public interface UserMapper {

	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);


    
    
    
//    ***********************************************
	
	/**登录验证*/
    User login(@Param("username")String username,@Param("password")String password);

    /**用户名验*/
	String check(String username);
	
	/**
	 * 用户管理--获取用户列表
	 * sql传入
	 * @return
	 */
	List<User> getUserListBySql(@Param("sqlString")String sqlString);
	
	/**
	 * 	添加用户的Role
	 * @param uid
	 * @param sql
	 */
	int addRoles(@Param("uid")String uid,@Param("sql")String sql);
	/**
	 * 删除用户的Role
	 * @param uid
	 * @param sql
	 */
	int delRoles(@Param("uid")String uid,@Param("sql")String sql);
}