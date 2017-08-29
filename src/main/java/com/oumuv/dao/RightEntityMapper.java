package com.oumuv.dao;

import com.oumuv.entity.RightEntity;

public interface RightEntityMapper {
    int deleteByPrimaryKey(Long rightCode);

    int insert(RightEntity record);

    int insertSelective(RightEntity record);

    RightEntity selectByPrimaryKey(Long rightCode);

    int updateByPrimaryKeySelective(RightEntity record);

    int updateByPrimaryKey(RightEntity record);
}