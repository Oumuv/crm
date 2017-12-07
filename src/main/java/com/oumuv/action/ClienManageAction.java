package com.oumuv.action;

import com.oumuv.service.ClienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Oumuv
 * @Date: Create in 2017/12/7 12:50
 */
public class ClienManageAction {

    @Autowired
    private ClienService clienService;


    @RequestMapping("word/clienManagePage.do")
    public String clienManagePage(ModelMap map){

        return "word/clienmanage";
    }


    @RequestMapping("word/getClienList.do")
    public String getClienList(String name,int pagesize,int pagenum,int status,ModelMap map){


        return null;
    }


}
