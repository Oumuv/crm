package com.oumuv.dao;

import java.util.List;

import com.oumuv.entity.RoleEntity;

public interface RoleEntityMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
    
    
    
    
//    *******************************************************
    
    List<RoleEntity> findRoleByUid(Long uid);
    
}