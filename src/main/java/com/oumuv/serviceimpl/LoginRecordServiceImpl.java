package com.oumuv.serviceimpl;

import java.util.List;
import java.util.Map;

import org.junit.Test;
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

	@Test
	public List<Map<String, String>> getloginRecoredForMonth(Long uid) {
		List<Map<String, String>> maplis;
		maplis= loginRecordDao.getloginRecoredForMonth(uid);
		return maplis;
	}

}
