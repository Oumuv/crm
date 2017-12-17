package com.oumuv.dao;

import com.oumuv.core.info.ClienInfo;
import com.oumuv.entity.ClienEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClienEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClienEntity record);

    int insertSelective(ClienEntity record);

    ClienEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClienEntity record);

    int updateByPrimaryKey(ClienEntity record);


    List<ClienInfo> getClienEntityByFiltrate(@Param("inputname") String inputname,
                                             @Param("source") String source,@Param("constomerType") String constomerType,
                                             @Param("status")String status, @Param("offset")Integer offset,@Param("pagesize") Integer pagesize);

    int getClienEntityByFiltrateSize(@Param("inputname") String inputname, @Param("source") String source,@Param("constomerType") String constomerType, @Param("status")String status);
}