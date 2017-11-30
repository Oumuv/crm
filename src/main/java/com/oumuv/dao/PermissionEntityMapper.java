package com.oumuv.dao;

import com.oumuv.entity.PermissionEntity;

public interface PermissionEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PermissionEntity record);

    int insertSelective(PermissionEntity record);

    PermissionEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionEntity record);

    int updateByPrimaryKey(PermissionEntity record);
}