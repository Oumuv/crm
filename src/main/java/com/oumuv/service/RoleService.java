package com.oumuv.service;

import java.util.List;

import com.oumuv.entity.RoleEntity;

public interface RoleService {
	
	/**
	 * 用户id获取权限
	 * @param id
	 * @return
	 */
	List<RoleEntity>getRoles(Long id);
	
}
