package com.oumuv.dao;

import com.oumuv.entity.ClienEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author: Oumuv
 * @Date: Create in 2017/12/8 11:32
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis-junit.xml"})
public class ClienEntityMapperTest {

    @Resource
    private ClienEntityMapper clienEntityMapper;


    @Test
    public void insert() {

        ClienEntity c = new ClienEntity();
        c.setName("金科");
        clienEntityMapper.insertSelective(c);
    }
}