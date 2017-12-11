package com.oumuv.action;

import com.oumuv.core.info.ClienInfo;
import com.oumuv.service.ClienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Oumuv
 * @Date: Create in 2017/12/7 12:50
 */
@Controller
public class ClienManageAction {

    @Autowired
    private ClienService clienService;


    @RequestMapping("word/clienManagePage.do")
    public String clienManagePage(ModelMap map) {

        return "word/clienmanage";
    }

    /**
     * 跳转添加页面
     *
     * @param map
     * @return
     */
    @RequestMapping("word/addclienManagePage.do")
    public String addclienManagePage(ModelMap map) {

        return "views/add_clien";
    }

    /**
     * 跳转修改页面
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("word/updataclienManagePage.do")
    public String updataclienManagePage(Long id, ModelMap map) {

        return "views/edit_clien";
    }

    /**
     * 获取ClienInfoList
     *
     * @param name 客户名
     * @param pagesize 页面显示的数据条数
     * @param pagenum 页数
     * @param constomerType 客户类型
     * @param status 客户状态
     * @param source 客户来源
     * @param map
     * @return
     */
    @RequestMapping("word/getClienList.do")
    public String getClienList(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "constomerType", required = false) String constomerType,
                               @RequestParam(value = "pagesize", required = false) String pagesize,
                               @RequestParam(value = "pagenum", required = false) String pagenum,
                               @RequestParam(value = "source", required = false) String source,
                               @RequestParam(value = "status", required = false) String status,
                               ModelMap map) {
        List<ClienInfo> cliens =  clienService.getClienEntityByFiltrate(name,source,constomerType,status,pagenum,pagesize);

        int i = 0;
        map.put("cliens", null);
        return "views/clien";
    }


}
