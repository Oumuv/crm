package com.oumuv.controllers;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.oumuv.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel文件控制器
 * 
 * @author Oumuv
 * 
 */
@Controller
public class ExcelController {


    /**
     * 使用easypoi的导出功能
     * @param request
     * @param response
     * @param session
     * @param map
     * @throws InterruptedException
     */
	@RequestMapping(value = "word/excelimport.do")
	public void pageResult(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap map) throws InterruptedException {

			User user = (User) session.getAttribute("user");
			List<User> list = new ArrayList<>();
			list.add(user);
			ExportParams params = new ExportParams("用户信息表", "呵呵哒", "num1");
			params.setFreezeCol(2);
			map.put(NormalExcelConstants.DATA_LIST, list);
			map.put(NormalExcelConstants.CLASS, User.class);
			map.put(NormalExcelConstants.PARAMS, params);
			map.put(NormalExcelConstants.FILE_NAME, "yonghu");
			PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);

	}
	


}
