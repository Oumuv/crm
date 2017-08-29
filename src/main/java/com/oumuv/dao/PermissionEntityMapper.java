package com.oumuv.dao;

import com.oumuv.entity.PermissionEntity;

public interface PermissionEntityMapper {
    int deleteByPrimaryKey(Long rfId);

    int insert(PermissionEntity record);

    int insertSelective(PermissionEntity record);

    PermissionEntity selectByPrimaryKey(Long rfId);

    int updateByPrimaryKeySelective(PermissionEntity record);

    int updateByPrimaryKey(PermissionEntity record);
}