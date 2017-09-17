package com.oumuv.service;

import java.util.List;
import java.util.Map;
import com.oumuv.entity.LoginRecordEntity;

public interface LoginRecordService {

	/**记录用户登录信息*/
	void loginRecored(LoginRecordEntity record);
	
	/**
	 * 获取用户近30天的登录次数信息
	 * */
	List<Map<String, String>> getloginRecoredForMonth(Long uid);
}
