package com.oumuv.service;

import com.oumuv.entity.ClienEntity;

import java.util.List;

public interface ClienService {
    /**
     * 添加
     * @param clienEntity
     * @return
     */
    public int addClien(ClienEntity clienEntity);

    /**
     * 更新
     * @param clienentity
     * @return
     */
    public int updataClien(ClienEntity clienentity);

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteClienById(Long id);

    /**
     * 查询
     * @param id
     * @return
     */
    public ClienEntity findClienEntityById(Long id);

    public List<ClienEntity> getClienEntityByName();

}
