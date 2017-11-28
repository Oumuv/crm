package com.oumuv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
