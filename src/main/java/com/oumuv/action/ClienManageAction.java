package com.oumuv.action;

import com.oumuv.service.ClienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Oumuv
 * @Date: Create in 2017/12/7 12:50
 */
@Controller
public class ClienManageAction {

    @Autowired
    private ClienService clienService;


    @RequestMapping("word/clienManagePage.do")
    public String clienManagePage(ModelMap map){

        return "word/clienmanage";
    }

    /**
     * 跳转添加页面
     * @param map
     * @return
     */
    @RequestMapping("word/addclienManagePage.do")
    public String addclienManagePage(ModelMap map){

        return "views/add_clien";
    }

    /**
     * 跳转修改页面
     * @param id
     * @param map
     * @return
     */
   @RequestMapping("word/updataclienManagePage.do")
    public String updataclienManagePage(Long id,ModelMap map){

        return "views/edit_clien";
    }

    /**
     * 获取ClienInfoList
     * @param name
     * @param pagesize
     * @param pagenum
     * @param status
     * @param map
     * @return
     */
    @RequestMapping("word/getClienList.do")
    public String getClienList(String name,int pagesize,int pagenum,int status,ModelMap map){

        return "views/clien";
    }



}
