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

}
