package com.oumuv.dao;

import java.util.List;

import com.oumuv.entity.MenuEntity;

public interface MenuEntityMapper {
    int deleteByPrimaryKey(Long rfId);

    int insert(MenuEntity record);

    int insertSelective(MenuEntity record);

    MenuEntity selectByPrimaryKey(Long rfId);

    int updateByPrimaryKeySelective(MenuEntity record);

    int updateByPrimaryKey(MenuEntity record);
    
    List<MenuEntity> findMenusByUid(Long uid);
}