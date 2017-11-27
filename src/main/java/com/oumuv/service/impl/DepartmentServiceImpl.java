package com.oumuv.service.impl;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumuv.dao.DepartmentEntityMapper;
import com.oumuv.dao.LoginRecordEntityMapper;
import com.oumuv.entity.DepartmentEntity;
import com.oumuv.entity.LoginRecordEntity;
import com.oumuv.service.DepartmentService;
import com.oumuv.service.LoginRecordService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentEntityMapper DepartmentDao;

	public List<DepartmentEntity> getAllEntity() {
		List<DepartmentEntity> list = DepartmentDao.getAllDepartmentEntity();
		return list;
	}

	public List<DepartmentEntity> getAllEntity(String input) {
		List<DepartmentEntity> list = DepartmentDao.getAllDepartmentEntityByInput(input);
		return list;
	}

	public DepartmentEntity getEntity(Long id) {
		DepartmentEntity entity = DepartmentDao.selectByPrimaryKey(id);
		return entity;
	}

	public int saveEntity(DepartmentEntity departmentEntity) {
		int i = DepartmentDao.updateByPrimaryKeySelective(departmentEntity);
		return i;
	}

	public int addEntity(DepartmentEntity departmentEntity) {
		int i = DepartmentDao.insert(departmentEntity);
		return i;
	}

	public int deleteEntity(Long id) {
		int i = DepartmentDao.deleteByPrimaryKey(id);
		return i;
	}

}
