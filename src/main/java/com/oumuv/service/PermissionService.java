package com.oumuv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oumuv.entity.PermissionEntity;

@Service
public interface PermissionService {

	/**
	 * 获取所有的permission
	 * @return
	 */
	public List<PermissionEntity> getAllPermission();
	
	/**
	 * 根据角色id获取权限
	 * @param rid
	 * @return
	 */
	public List<String> getPermissionNameListByRid(Long rid);
	/**
	 * 根据角色id获取permissionEntity
	 * @param rid
	 * @return
	 */
	public List<PermissionEntity> getPermissionListByRid(Long rid);
	
}
