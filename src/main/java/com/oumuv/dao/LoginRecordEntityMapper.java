package com.oumuv.dao;

import java.util.List;
import java.util.Map;

import com.oumuv.entity.LoginRecordEntity;

public interface LoginRecordEntityMapper {
    int insert(LoginRecordEntity record);

    int insertSelective(LoginRecordEntity record);
    
    /**
     *获取用户近30天的登陆记录，并统计每天登陆的次数
     * @param uid 用户id
     * @return
     */
    List<Map<String, String>> getloginRecoredForMonth(Long uid);
}