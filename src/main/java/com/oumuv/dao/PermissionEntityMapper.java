package com.oumuv.dao;

import java.util.List;

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
    
}