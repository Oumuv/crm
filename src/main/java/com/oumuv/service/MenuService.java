package com.oumuv.service;

import java.util.List;

import com.oumuv.entity.RightEntity;

public interface MenuService {
	/**根据用户id获取用户菜单*/
	public List<RightEntity> getMenuByUid(Long id);
	
	/**获取所有的菜单*/
	public List<RightEntity> getAllMenus();
	
	/**修改菜单信息*/
	public void updataMenu(RightEntity rightEntity);
	
	/**根据id获取菜单*/
	public RightEntity getMenu(Long id);
	
	/**添加菜单*/
	public void insertMenu(RightEntity rightEntity);
	
	/**根据菜单级别获取菜单*/
	public List<RightEntity> getMenuByLevel(int level);
	
	/**根据id删除菜单*/
	public int delMenuByLevel(List<Long> ids);
}