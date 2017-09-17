package com.oumuv.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oumuv.entity.RightEntity;
import com.oumuv.service.MenuService;

@Controller
public class MenuAction {
	
	@Autowired
	MenuService menuservice;
	
	/**获取用户菜单*/
	@RequestMapping("/getmenu.do")
	public void getMenu(@Param("id")Long id,HttpServletRequest request,HttpServletResponse response,Model model){
		List<RightEntity> menu = menuservice.getMenu(1L);
		try {
			response.getWriter().write(JSONArray.toJSONString(menu));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
