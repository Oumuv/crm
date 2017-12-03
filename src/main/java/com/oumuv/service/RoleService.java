package com.oumuv.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.oumuv.core.info.RoleInfo;
import com.oumuv.entity.PermissionEntity;
import com.oumuv.entity.RoleEntity;

@Service
public interface RoleService {
	
	/**
	 * 用户id获取角色
	 * @param id
	 * @return
	 */
	List<String>getRoles(Long id);
	List<RoleEntity> getRoleEntitys(Long id);
	
	/**
	 * 根据用户id获取权限
	 * @param id
	 * @return
	 */
	Set<PermissionEntity> getPermissionsByUid(Long id);
	/**
	 * search搜索获取role
	 * @param name
	 * @return
	 */
	List<RoleEntity> getRoleByInput(String name);
	/**
	 *  search搜索获取roleInfo
	 * @param name
	 * @return
	 */
	List<RoleInfo> findRoleByInputResult(String name);
	
	int addRole(RoleEntity roleEntity);
	
	int deleteRole(Long id);
	
	/**
	 * 更新roleEntity，同时更新roleEntity对应的permission和menu的桥表
	 * @param roleEntity
	 * @param menus
	 * @param permissions
	 * @return
	 */
	int updataRole(RoleEntity roleEntity,List<Long> menus,List<Long> permissions);
	
	RoleEntity getRole(Long id);
	
}
