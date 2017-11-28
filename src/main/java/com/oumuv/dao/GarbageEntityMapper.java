package com.oumuv.dao;

import com.oumuv.entity.GarbageEntity;

public interface GarbageEntityMapper {

	int deleteByPrimaryKey(Long id);

    int insert(GarbageEntity record);

    int insertSelective(GarbageEntity record);

    GarbageEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GarbageEntity record);

    int updateByPrimaryKey(GarbageEntity record);
}