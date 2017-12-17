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
import org.springframework.web.bind.annotation.ResponseBody;

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
        ClienEntity clienEntity = clienService.findClienEntityById(id);
        map.put("clien", clienEntity);
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
                               @RequestParam(value = "pagesize", required = false) Integer pagesize,
                               @RequestParam(value = "pagenum", required = false) Integer pagenum,
                               @RequestParam(value = "source", required = false) String source,
                               @RequestParam(value = "status", required = false) String status,
                               ModelMap map) {
        List<ClienInfo> cliens =  clienService.getClienEntityByFiltrate(name,source,customerType,status,pagenum,pagesize);
        map.put("cliens", cliens);
       int countIndex = pagesize * (pagenum - 1);
        map.put("count_index", countIndex);
        return "views/clien";
    }

    @RequestMapping("word/resetpage.do")
    @ResponseBody
    public int resetPage(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "customerType", required = false) String customerType,
                          @RequestParam(value = "source", required = false) String source,
                          @RequestParam(value = "status", required = false) String status,
                          HttpServletResponse response) {
        final int i = clienService.getClienEntityByFiltrateSize(name, source, customerType, status);
        return i;
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

    /**
     *修改客户信息
     * @param clienEntity
     * @param response
     * @throws IOException
     */
    @RequestMapping("word/updataClien.do")
    public void updataClien(ClienEntity clienEntity, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        int i = clienService.updataClien(clienEntity);
        if (i > 0) {
            response.getWriter().write("修改成功");
        }else{
            response.getWriter().write("修改失败");
        }
    }

    /**
     * 删除
     * @param id
     * @param response
     * @throws IOException
     */
    @RequestMapping("word/deleteClien.do")
    public void deleteClien(Long id, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        int i = clienService.deleteClienById(id);
        if (i > 0) {
            response.getWriter().write("删除成功");
        }else{
            response.getWriter().write("删除失败");
        }
    }


}
