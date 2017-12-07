package com.oumuv.service.impl;

import com.oumuv.dao.ClienEntityMapper;
import com.oumuv.entity.ClienEntity;
import com.oumuv.service.ClienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienServiceImpl implements ClienService {


    @Autowired
    private ClienEntityMapper clienDao;

    public int addClien(ClienEntity clienEntity) {
        int i = clienDao.insertSelective(clienEntity);
        return i;
    }

    public int updataClien(ClienEntity clienentity) {
        return 0;
    }

    public int deleteClienById(Long id) {
        return 0;
    }

    public ClienEntity findClienEntityById(Long id) {
        return null;
    }

    public List<ClienEntity> getClienEntityByName() {
        return null;
    }
}
