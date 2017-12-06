package com.oumuv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumuv.dao.PermissionEntityMapper;
import com.oumuv.dao.RoleEntityMapper;
import com.oumuv.entity.PermissionEntity;
import com.oumuv.entity.User;
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

	public List<PermissionEntity> getAllPermission() {
		List<PermissionEntity> allPermissionEntity = permissionDao.getAllPermissionEntity();
		return allPermissionEntity;
	}

	public List<PermissionEntity> getPermissionListByRid(Long rid) {
		return permissionDao.getPermissionEntityByRid(rid);
	}

	public List<PermissionEntity> getPermissionListByNameAndLevel(String name,
			String level) {
		
		String sql = "SELECT * FROM permission_info";
		List<PermissionEntity> PermissionEntitys = new ArrayList<PermissionEntity>();
		boolean nameflag = null!=name&&!name.equals("");
		boolean levelflag = null!=level&&!level.equals("");
		if (!nameflag && !levelflag) {// 如果都为空
			PermissionEntitys = permissionDao.getPermissionListByNameAndLevel(sql);
		} else {
			sql += " WHERE ";
			if (!nameflag) {// 如果name为空
				sql += " level=" + level;
			} else if (!levelflag) {// 如果did为空
				sql += " name LIKE BINARY '%" + name + "%'";
			} else {// 如果都不为空
				sql += " name LIKE BINARY '%" + name + "%'";
				sql += " AND level=" + level;
			}
			PermissionEntitys = permissionDao.getPermissionListByNameAndLevel(sql);
		}
		return PermissionEntitys;
	}

	public int addPermission(PermissionEntity p) {
		return permissionDao.insertSelective(p);
	}

	public int updataPermission(PermissionEntity p) {
		return permissionDao.updateByPrimaryKeySelective(p);
	}

	public int deletePermission(Long id) {
		return permissionDao.deleteByPrimaryKey(id);
	}

	public PermissionEntity getPermissionById(Long id) {
		return permissionDao.selectByPrimaryKey(id);
	}

	
}
