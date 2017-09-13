package com.oumuv.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumuv.dao.LoginRecordEntityMapper;
import com.oumuv.entity.LoginRecordEntity;
import com.oumuv.service.LoginRecordService;

@Service
public class LoginRecordServiceImpl implements LoginRecordService{

	@Autowired
	private LoginRecordEntityMapper loginRecordDao;
	
	public void loginRecored(LoginRecordEntity record) {
		loginRecordDao.insertSelective(record);
	}

}
