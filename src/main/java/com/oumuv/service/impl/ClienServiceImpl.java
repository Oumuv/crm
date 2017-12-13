package com.oumuv.service.impl;

import com.oumuv.core.info.ClienInfo;
import com.oumuv.dao.ClienEntityMapper;
import com.oumuv.entity.ClienEntity;
import com.oumuv.service.ClienService;
import org.junit.Test;
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
        ClienEntity clienEntity = clienDao.selectByPrimaryKey(id);
        return clienEntity;
    }

    public List<ClienInfo> getClienEntityByFiltrate(String name, String source, String customerType, String status, String pagenum, String pagesize) {
        List<ClienInfo> cliengs = clienDao.getClienEntityByFiltrate(name,splitString(source),splitString(customerType),splitString(status),"15","15");
        return cliengs;
    }


    /**
     *字符串拼接
     * 原字符串：潜在客户,意向客户
     * 拼接后字符串：'潜在客户','意向客户'
     * @param str
     * @return
     */
    private String splitString(String str){
        String result = "";
        if (null != str) {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                result += "'";
                result += split[i] + "',";
            }
            result = result.substring(0, result.length() - 1);
        }else{
            return null;
        }
        return result;
    }


}
