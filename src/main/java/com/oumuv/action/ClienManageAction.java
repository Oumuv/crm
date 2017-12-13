package com.oumuv.action;

import com.oumuv.core.info.ClienInfo;
import com.oumuv.entity.ClienEntity;
import com.oumuv.entity.User;
import com.oumuv.service.ClienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
     * @param customerType 客户类型
     * @param status 客户状态
     * @param source 客户来源
     * @param map
     * @return
     */
    @RequestMapping("word/getClienList.do")
    public String getClienList(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "customerType", required = false) String customerType,
                               @RequestParam(value = "pagesize", required = false) String pagesize,
                               @RequestParam(value = "pagenum", required = false) String pagenum,
                               @RequestParam(value = "source", required = false) String source,
                               @RequestParam(value = "status", required = false) String status,
                               ModelMap map) {
        List<ClienInfo> cliens =  clienService.getClienEntityByFiltrate(name,source,customerType,status,pagenum,pagesize);
        map.put("cliens", cliens);
        return "views/clien";
    }

    /**
     * 添加客户
     * @param clienEntity
     * @param response
     * @throws IOException
     */
    @RequestMapping("word/addClien.do")

    public void addClien(ClienEntity clienEntity, HttpServletResponse response, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        clienEntity.setUid(user.getId());
        response.setCharacterEncoding("utf-8");
        int i = clienService.addClien(clienEntity);
        if (i > 0) {
            response.getWriter().write("添加客户成功");
        }else{
            response.getWriter().write("添加客户失败");
        }

    }


}
