package com.oumuv.dao;

import com.oumuv.entity.ClienEntity;

public interface ClienEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClienEntity record);

    int insertSelective(ClienEntity record);

    ClienEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClienEntity record);

    int updateByPrimaryKey(ClienEntity record);
}