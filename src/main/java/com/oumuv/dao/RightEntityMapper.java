package com.oumuv.dao;

import java.util.List;

import com.oumuv.entity.RightEntity;

public interface RightEntityMapper {

	int deleteByPrimaryKey(Long rightCode);

	int insert(RightEntity record);

	int insertSelective(RightEntity record);

	RightEntity selectByPrimaryKey(Long rightCode);

	int updateByPrimaryKeySelective(RightEntity record);

	int updateByPrimaryKey(RightEntity record);

    
//    **************************************************
	/**根据用户id获取用户的权限菜单*/
	List<RightEntity> getRightByUId(long uid);
	
	/**根据父id获取子对象*/
	List<RightEntity> getRightByParentId(long pid);
	
	/**获取所有的RightEntity*/
	List<RightEntity> getAllRightEntity();
	
	/**根据level获取所有的RightEntity*/
	List<RightEntity> getMenuByLevel(int level);
	
}