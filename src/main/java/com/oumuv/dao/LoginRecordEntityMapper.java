package com.oumuv.dao;

import com.oumuv.entity.LoginRecordEntity;

public interface LoginRecordEntityMapper {
    int insert(LoginRecordEntity record);

    int insertSelective(LoginRecordEntity record);
}