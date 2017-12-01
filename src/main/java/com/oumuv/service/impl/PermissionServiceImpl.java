package com.oumuv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumuv.dao.PermissionEntityMapper;
import com.oumuv.dao.RoleEntityMapper;
import com.oumuv.entity.PermissionEntity;
import com.oumuv.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionEntityMapper permissionDao;
	
	public List<String> getPermissionNameListByRid(Long rid) {
		List<PermissionEntity> permissionEntityByRid = permissionDao.getPermissionEntityByRid(rid);
		List<String> list = new ArrayList<String>();
		for(PermissionEntity p:permissionEntityByRid){
			list.add(p.getName());
		}
		return list;
	}

	
}
