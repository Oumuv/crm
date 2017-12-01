package com.oumuv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oumuv.core.info.RoleInfo;
import com.oumuv.entity.RoleEntity;

public interface RoleEntityMapper {

	int deleteByPrimaryKey(Long roleId);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
    
    
    
    
//    *******************************************************
    /**
     * 根据用户id获取role
     * @param uid
     * @return
     */
    List<RoleEntity> findRoleByUid(Long uid);
    
    List<RoleEntity> findRoleByInput(@Param("name")String name);
    List<RoleInfo> findRoleByInputResult(@Param("name")String name);
}