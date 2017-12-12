package com.oumuv.service;

import com.oumuv.core.info.ClienInfo;
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

    /**
     *
     * @param name
     * @param source
     * @param status
     * @param pagenum
     * @param customerType
     * @param pagesize
     * @return
     */
    public List<ClienInfo> getClienEntityByFiltrate(String name, String source, String customerType, String status, String pagenum, String pagesize);


}
