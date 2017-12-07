package com.oumuv.service;

import com.oumuv.entity.ClienEntity;

public interface ClienService {
    /**
     * 添加
     * @param clienEntity
     * @return
     */
    public int addClien(ClienEntity clienEntity);

    public int updataClien(ClienEntity clienentity);

    public int deleteClienById(Long id);

    public ClienEntity findClienEntityById(Long id);
}
