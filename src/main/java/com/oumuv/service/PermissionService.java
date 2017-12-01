package com.oumuv.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PermissionService {

	/**
	 * 根据角色id获取权限
	 * @param rid
	 * @return
	 */
	public List<String> getPermissionNameListByRid(Long rid);
	
}
