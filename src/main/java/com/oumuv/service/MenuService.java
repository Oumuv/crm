package com.oumuv.service;

import java.util.List;

import com.oumuv.entity.RightEntity;

public interface MenuService {
	/**根据用户id获取用户菜单*/
	public List<RightEntity> getMenu(Long id);
}
