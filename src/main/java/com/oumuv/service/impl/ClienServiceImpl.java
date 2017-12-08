package com.oumuv.service.impl;

import com.oumuv.core.info.ClienInfo;
import com.oumuv.dao.ClienEntityMapper;
import com.oumuv.entity.ClienEntity;
import com.oumuv.service.ClienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.*;

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

    public List<ClienInfo> getClienEntityByFiltrate(String name, String source, String constomerType, String status, String pagenum, String pagesize) {

        boolean nameflag = null != name && !name.equals("");
        boolean sourceflag = null != source && !source.equals("");
        boolean constomerTypeflag = null != constomerType && !constomerType.equals("");
        boolean statusflag = null != status && !status.equals("");
        boolean pagenumflag = null != pagenum && !pagenum.equals("");
        boolean pagesizeflag = null != pagesize && !pagesize.equals("");


        int offset = 15;
        if(pagenumflag && pagesizeflag){
             offset = parseInt(pagesize)* parseInt(pagenum);
        }
        List<ClienInfo> cliengs = clienDao.getClienEntityByFiltrate(name,source,constomerType,status, String.valueOf(offset));
        return cliengs;
    }
}
