package com.oumuv.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oumuv.core.info.RoleInfo;
import com.oumuv.dao.PermissionEntityMapper;
import com.oumuv.dao.RightEntityMapper;
import com.oumuv.dao.RoleEntityMapper;
import com.oumuv.entity.PermissionEntity;
import com.oumuv.entity.RightEntity;
import com.oumuv.entity.RoleEntity;
import com.oumuv.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleEntityMapper RoleDao;
	@Autowired
	private RightEntityMapper menuDao;
	@Autowired
	private PermissionEntityMapper permissionDao;
	
	public List<String> getRoles(Long uid) {
		List<RoleEntity> list = RoleDao.findRoleByUid(uid);
		List<String> rlist = new ArrayList<String>();
		for(RoleEntity r:list){
			rlist.add(r.getRoleName());
		}
		return rlist;
	}
	public List<RoleEntity> getRoleEntitys(Long uid) {
		List<RoleEntity> list = RoleDao.findRoleByUid(uid);
		return list;
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
	
	@Transactional
	public int updataRole(RoleEntity roleEntity,List<Long> menus,List<Long> permissions) {
		Long roleId = roleEntity.getRoleId();
		if(null!=menus&&menus.size()>0){
			List<RightEntity> menuByRid = menuDao.getMenuByRid(roleId);
			List<Long> oldMenuId = new ArrayList<Long>();
			for(RightEntity r:menuByRid){
				oldMenuId.add(r.getRightCode());
			}
			List<Long> delMenuId = setDifferenceSet(oldMenuId,menus);
			List<Long> addMenuId = setDifferenceSet(menus,oldMenuId);
			if(null!=delMenuId&&delMenuId.size()>0){
				String Sql = jointSql2(delMenuId);
				int i = RoleDao.deleteMenusByRidAndMids(roleId.toString(),Sql);
				System.out.println("删除菜单"+i+"个");
			}
			if(null!=addMenuId&&addMenuId.size()>0){
				String jointSql = jointSql(roleId,addMenuId);
				int i = RoleDao.insertMenusByRidAndMids(jointSql);
				System.out.println("添加菜单"+i+"个");
			}
		}
		if(null!=permissions&&permissions.size()>0){
			List<PermissionEntity> permissionEntityByRid = permissionDao.getPermissionEntityByRid(roleId);
			List<Long> oldPermissionId = new ArrayList<Long>();
			for(PermissionEntity p:permissionEntityByRid){
				oldPermissionId.add(p.getId());
			}
			List<Long> delPId = setDifferenceSet(oldPermissionId,permissions);
			List<Long> addPId = setDifferenceSet(permissions,oldPermissionId);
			if(null!=delPId&&delPId.size()>0){
				String Sql = jointSql2(delPId);
				int i = RoleDao.deletePsermissionByRidAndPids(roleId.toString(),Sql);
				System.out.println("删除权限"+i+"个");
			}
			if(null!=addPId&&addPId.size()>0){
				String jointSql = jointSql(roleId,addPId);
				int i = RoleDao.insertPsermissionByRidAndPids(jointSql);
				System.out.println("添加权限"+i+"个");
			}
		}
		return RoleDao.updateByPrimaryKeySelective(roleEntity);
	}
	
	
	/**
	 * 集合差集运算
	 * @return
	 */
	private List<Long> setDifferenceSet(List<Long> list1,List<Long> list2){
		List<Long> list = new ArrayList<Long>();
		list.addAll(list1);
		list.removeAll(list2);
		return list;
	}
	
	/**
	 * 拼接sql
	 * 格式"({@link rid},{@link ids}),({@link rid},{@link ids})"
	 * @param rid
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unused")
	private String jointSql(Long rid,List<Long> ids){
		String sql = "";
		for(Long id:ids){
			sql += "("+rid+","+id+"),";
		}
		return sql.substring(0, sql.length()-1);
	}
	/**
	 * 拼接sql
	 * 格式({@link id},{@link id})
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unused")
	private String jointSql2(List<Long> ids){
		String sql = "(";
		for(Long id:ids){
			sql += id+",";
		}
		return sql.substring(0, sql.length()-1)+")";
	}

	public RoleEntity getRole(Long id) {
		RoleEntity selectByPrimaryKey = RoleDao.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}
	public Set<PermissionEntity> getPermissionsByUid(Long id) {
		Set<PermissionEntity> permissionEntityByUid = permissionDao.getPermissionEntityByUid(id);
		return permissionEntityByUid;
	}
	public List<RoleEntity> getAllRoleEntitys() {
		
		return RoleDao.getAllRoleEntity();
	}

}
