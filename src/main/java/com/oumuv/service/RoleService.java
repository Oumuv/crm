package com.oumuv.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
}
