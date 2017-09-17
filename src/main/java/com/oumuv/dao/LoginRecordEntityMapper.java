package com.oumuv.dao;

import java.util.List;
import java.util.Map;

import com.oumuv.entity.LoginRecordEntity;

public interface LoginRecordEntityMapper {
    int insert(LoginRecordEntity record);

    int insertSelective(LoginRecordEntity record);
    
    List<Map<String, String>> getloginRecoredForMonth(Long uid);
}