package com.oumuv.service;

import java.util.List;

import com.oumuv.entity.DepartmentEntity;


public interface DepartmentService {
	
	
	/**
	 * 所有的部门获取
	 * @return
	 */
	public List<DepartmentEntity> getAllEntity();
	
	/**
	 * 模糊搜索 
	 * @param input
	 * @return
	 */
	public List<DepartmentEntity> getAllEntity(String input);
	
	public DepartmentEntity getEntity(Long id);
	
	public int saveEntity(DepartmentEntity departmentEntity);
	
	public int addEntity(DepartmentEntity departmentEntity);
	
	public int deleteEntity(Long id);
}
