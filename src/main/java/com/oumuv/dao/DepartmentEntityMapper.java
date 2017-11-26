package com.oumuv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oumuv.entity.DepartmentEntity;

public interface DepartmentEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DepartmentEntity record);

    int insertSelective(DepartmentEntity record);

    DepartmentEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DepartmentEntity record);

    int updateByPrimaryKey(DepartmentEntity record);
    
    
    /****************************************************/
    /**
     * 获取所有的部门
     * @return
     */
    public List<DepartmentEntity> getAllDepartmentEntity();
    
    public List<DepartmentEntity> getAllDepartmentEntityByInput(@Param("input")String input);
    
    
    
}