package com.oumuv.dao;

import com.oumuv.entity.DepartmentEntity;

public interface DepartmentEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DepartmentEntity record);

    int insertSelective(DepartmentEntity record);

    DepartmentEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DepartmentEntity record);

    int updateByPrimaryKey(DepartmentEntity record);
}