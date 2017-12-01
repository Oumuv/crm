package com.oumuv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oumuv.core.info.RoleInfo;
import com.oumuv.dao.RoleEntityMapper;
import com.oumuv.entity.RoleEntity;
import com.oumuv.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleEntityMapper RoleDao;
	
	public List<String> getRoles(Long uid) {
		List<RoleEntity> list = RoleDao.findRoleByUid(uid);
		List<String> rlist = new ArrayList<String>();
		for(RoleEntity r:list){
			rlist.add(r.getRoleName());
		}
		return rlist;
	}

	public List<RoleEntity> getRoleByInput(String name) {
		List<RoleEntity> list = RoleDao.findRoleByInput(name);
		return list;
	}
	public List<RoleInfo> findRoleByInputResult(String name) {
		List<RoleInfo> list = RoleDao.findRoleByInputResult(name);
		return list;
	}

	public int addRole(RoleEntity roleEntity) {
		int insert = RoleDao.insert(roleEntity);
		return insert;
	}

	public int deleteRole(Long id) {
		return RoleDao.deleteByPrimaryKey(id);
	}

	public int updataRole(RoleEntity roleEntity) {
		
		return RoleDao.updateByPrimaryKeySelective(roleEntity);
	}

	public RoleEntity getRole(Long id) {
		RoleEntity selectByPrimaryKey = RoleDao.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

}
