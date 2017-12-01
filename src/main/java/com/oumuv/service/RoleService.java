package com.oumuv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oumuv.core.info.RoleInfo;
import com.oumuv.entity.RoleEntity;

@Service
public interface RoleService {
	
	/**
	 * 用户id获取权限
	 * @param id
	 * @return
	 */
	List<String>getRoles(Long id);
	
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
	
	int updataRole(RoleEntity roleEntity);
	
	RoleEntity getRole(Long id);
	
}
