package com.oumuv.service;

import com.oumuv.entity.LoginRecordEntity;

public interface LoginRecordService {

	/**记录用户登录信息*/
	void loginRecored(LoginRecordEntity record);
}
