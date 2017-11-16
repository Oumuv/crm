package com.oumuv.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.oumuv.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

    
    
    
//    ***********************************************
    User login(@Param("username")String username,@Param("password")String password);

	String check(String username);
}