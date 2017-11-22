package com.oumuv.service;

import java.util.List;

import com.oumuv.entity.DepartmentEntity;


public interface DepartmentService {
	
	
	/**
	 * 所有的部门获取
	 * @return
	 */
	public List<DepartmentEntity> getAllEntity();
	
	
}
