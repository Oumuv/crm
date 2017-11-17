package com.oumuv.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oumuv.core.MenuInfo;
import com.oumuv.entity.RightEntity;
import com.oumuv.entity.User;
import com.oumuv.service.MenuService;

@Controller
public class MenuAction {
	
	@Autowired
	private MenuService menuservice;
	
	/**获取用户菜单
	 * @throws IOException */
	@RequestMapping("/user/getmenu.do")
	public String getMenu(HttpSession session,HttpServletResponse response,ModelMap map) throws IOException{
		User user = (User) session.getAttribute("user");
		List<RightEntity> menu = menuservice.getMenu(user.getId());
		List<MenuInfo> menuresult = new LinkedList<MenuInfo>();//最后的结果 
		
		//遍历一级菜单，一级菜单没有parentid
		for(RightEntity m:menu){
			if(m.getRightType().equals("1")){
				MenuInfo mi = new MenuInfo();
				mi.setId(m.getRightCode());
				mi.setName(m.getRightText());
				mi.setUrl(m.getRightUrl());
				menuresult.add(mi);
			}
		}
		//获取一级菜单的子菜单
		for(MenuInfo m:menuresult){
			List<MenuInfo> getchild = getchild(m.getId(),menu);
			if(getchild.size()>0){
				m.setMenus(getchild);
			}
		}
		map.put("menulist", menuresult);
		return "views/menu";
	}
	
	/**
	 * 根据父菜单id遍历子菜单     可迭代函数
	 */
	private List<MenuInfo> getchild(Long pid,List<RightEntity> menu){
		List<MenuInfo> list = new LinkedList<MenuInfo>();
		for(RightEntity m:menu){
			if(m.getRightParentCode()==pid){
				MenuInfo mi = new MenuInfo();
				mi.setId(m.getRightCode());
				mi.setName(m.getRightText());
				mi.setUrl(m.getRightUrl());
				if(m.getIspatent()){
					List<MenuInfo> getchild = getchild(m.getRightCode(),menu);//迭代遍历子菜单
					mi.setMenus(getchild);
				}
				list.add(mi);
			}
		}
		return list;
	}
	
	/**
	 * 获取所有menu转换成json数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/testurl/getmenu.json.do")
	public void getmenujson(HttpServletResponse response){
		String json = "";
		response.setCharacterEncoding("utf-8");
		List<RightEntity> menu = menuservice.getMenu(1L);
		List<MenuInfo> menuresult = new LinkedList<MenuInfo>();//最后的结果 
		
		//遍历一级菜单，一级菜单没有parentid
		for(RightEntity m:menu){
			if(m.getRightType().equals("1")){
				MenuInfo mi = new MenuInfo();
				mi.setId(m.getRightCode());
				mi.setName(m.getRightText());
				mi.setUrl(m.getRightUrl());
				menuresult.add(mi);
			}
		}
		//获取一级菜单的子菜单
		for(MenuInfo m:menuresult){
			List<MenuInfo> getchild = getchild(m.getId(),menu);
			if(getchild.size()>0){
				m.setMenus(getchild);
			}
		}
		
		json = getjson(menuresult);
		System.out.println(json);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**转换json*/
	private String getjson(List<MenuInfo> list){
		String json = "[";
		for(MenuInfo mi:list){
			json+="{\"text\":\""+mi.getName()+"\",";
			if(null!=mi.getMenus()&&mi.getMenus().size()>0){
				json += "\"nodes\":";
				json += getjson(mi.getMenus());
				json += ",";
			}
			json = json.substring(0, json.length()-1);
			json += "},";
		}
		json = json.substring(0, json.length()-1);
		json += "]";
		return json;
	}
	
	
}
