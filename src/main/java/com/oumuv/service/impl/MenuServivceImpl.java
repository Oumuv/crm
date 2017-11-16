package com.oumuv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumuv.dao.RightEntityMapper;
import com.oumuv.entity.RightEntity;
import com.oumuv.service.MenuService;

@Service
public class MenuServivceImpl implements MenuService{

	@Autowired
	private RightEntityMapper menuDao;
	/**
	 * 获取菜单
	 * */
	public List<RightEntity> getMenu(Long id) {
		List<RightEntity> rightByUId = menuDao.getRightByUId(1L);
		return rightByUId;
	}

}
