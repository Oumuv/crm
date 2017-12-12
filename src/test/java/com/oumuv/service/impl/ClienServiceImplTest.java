package com.oumuv.service.impl;

import com.oumuv.core.info.ClienInfo;
import com.oumuv.entity.ClienEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: Oumuv
 * @Date: Create in 2017/12/8 12:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis-junit.xml"})
public class ClienServiceImplTest {


    @Autowired
    private ClienServiceImpl clienServiceImpl;
    @Test
    public void addClien() {


        ClienEntity c = new ClienEntity();
        c.setName("马云");
        clienServiceImpl.addClien(c);
    }


    @Test
    public void getClienEntityByFiltrate() {
        String name = "罗";
        String source = null;
        String customerType= null;
        String status = null;
        String offsest = "15";


        List<ClienInfo> cliengs = clienServiceImpl.getClienEntityByFiltrate(name, source, customerType, status, "1", "15");
        int i = 0;
    }

    @Test
    public void getClienEntityByFiltrate2() {
        String name = "罗";
        String source = null;
        String customerType= null;
        String status = null;
        String offsest = "15";
        List<ClienEntity> clienEntityByFiltrate2 = clienServiceImpl.getClienEntityByFiltrate2(name, source, customerType, status, "1", "15");
        int i = 0;
    }
}