package com.oumuv.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.oumuv.entity.PermissionEntity;

public interface PermissionEntityMapper {
	
int deleteByPrimaryKey(Long id);

	int insert(PermissionEntity record);

	int insertSelective(PermissionEntity record);

	PermissionEntity selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PermissionEntity record);

	int updateByPrimaryKey(PermissionEntity record);

    
    
//    ********************************************************************
    
    /**
     * 根据角色id获取PermissionEntity
     * @param rid
     * @return
     */
    List<PermissionEntity> getPermissionEntityByRid(@Param("rid")Long rid);
    /**
     * 获取所有的permission
     * @return
     */
    List<PermissionEntity> getAllPermissionEntity();
    /**
     * 根据name和level模糊搜索  
     * @return
     */
    List<PermissionEntity> getPermissionListByNameAndLevel(@Param("sql")String sql);
    
    Set<PermissionEntity> getPermissionEntityByUid(@Param("uid")Long uid);
    
}