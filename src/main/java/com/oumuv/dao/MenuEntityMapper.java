package com.oumuv.dao;

import com.oumuv.entity.MenuEntity;

public interface MenuEntityMapper {
    int deleteByPrimaryKey(Long rfId);

    int insert(MenuEntity record);

    int insertSelective(MenuEntity record);

    MenuEntity selectByPrimaryKey(Long rfId);

    int updateByPrimaryKeySelective(MenuEntity record);

    int updateByPrimaryKey(MenuEntity record);
}