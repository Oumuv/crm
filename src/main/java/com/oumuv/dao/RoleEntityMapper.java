package com.oumuv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oumuv.core.info.RoleInfo;
import com.oumuv.entity.RoleEntity;

public interface RoleEntityMapper {

	int deleteByPrimaryKey(Long roleId);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
    
    
    
    
//    *******************************************************
    /**
     * 根据用户id获取role
     * @param uid
     * @return
     */
    List<RoleEntity> findRoleByUid(Long uid);
    /**
     * 根据搜索名称获取roleEntity
     * @param name
     * @return
     */
    List<RoleEntity> findRoleByInput(@Param("name")String name);
    
    /***
     * 搜索名称获取RoleInfo
     * @param name
     * @return
     */
    List<RoleInfo> findRoleByInputResult(@Param("name")String name);
    
  
    int insertMenusByRidAndMids(@Param("sql")String sql);
   
    int insertPsermissionByRidAndPids(@Param("sql")String sql);
    
    int deleteMenusByRidAndMids(@Param("rid")String rid,@Param("sql")String sql);
    
    int deletePsermissionByRidAndPids(@Param("rid")String rid,@Param("sql")String sql);
    /**
     * 获取所有的RoleEntity
     * @return
     */
    List<RoleEntity> getAllRoleEntity();
}