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
	
	/**
	 * 根据搜索name和level获取PermissionEntity
	 * @param name
	 * @param level
	 * @return
	 */
	public List<PermissionEntity> getPermissionListByNameAndLevel(String name,String level);
	
	/**
	 * 添加
	 * @param p
	 * @return
	 */
	public int addPermission(PermissionEntity p);
	
	/**
	 * 更新
	 * @param p
	 * @return
	 */
	public int updataPermission(PermissionEntity p);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public int deletePermission(Long id);
	
	/**
	 * 根据pid获取permissionEntity
	 * @param id
	 * @return
	 */
	public PermissionEntity getPermissionById(Long id);
	
}
