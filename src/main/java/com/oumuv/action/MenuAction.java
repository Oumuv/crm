package com.oumuv.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oumuv.core.MenuInfo;
import com.oumuv.entity.RightEntity;
import com.oumuv.entity.User;
import com.oumuv.service.MenuService;

@Controller
public class MenuAction {
	
	@Autowired
	private MenuService menuservice;
	
	
	/**
	 * 跳转菜单管理页面
	 * @return
	 */
	@RequestMapping("/word/Menumanage.do")
	public String goMenumanage(){
		
		return "views/menumanage";
	}
	
	/**获取用户菜单
	 * @throws IOException */
	@RequestMapping("/user/getmenu.do")
	public String getMenu(HttpSession session,HttpServletResponse response,ModelMap map) throws IOException{
		User user = (User) session.getAttribute("user");
		List<RightEntity> menu = menuservice.getMenuByUid(user.getId());
		List<MenuInfo> menuresult = new LinkedList<MenuInfo>();//最后的结果 
		
		//遍历一级菜单，一级菜单没有parentid
		for(RightEntity m:menu){
			if(m.getRightType()==1){
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
				mi.setTip(m.getRightTip());
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
	 * 获取所有menu并转换成json数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/word/getmenu.json.do")
	public void getmenujson(HttpServletResponse response){
		String json = "";
		response.setCharacterEncoding("utf-8");
		List<RightEntity> menu = menuservice.getAllMenus();
		List<MenuInfo> menuresult = new LinkedList<MenuInfo>();//最后的结果 
		
		//遍历一级菜单，一级菜单没有parentid
		for(RightEntity m:menu){
			if(m.getRightType()==1){
				MenuInfo mi = new MenuInfo();
				mi.setId(m.getRightCode());
				mi.setName(m.getRightText());
				mi.setUrl(m.getRightUrl());
				mi.setTip(m.getRightTip());
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
//		System.out.println(json);
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
			json += "{\"text\":\""+mi.getName()+"<input type='hidden' value='start"+mi.getId()+"end'></input>\",";
			if(null!=mi.getMenus()&&mi.getMenus().size()>0){
				json += "\"tags\":[\"子菜单个数："+mi.getMenus().size()+"\",";
				if(null!=mi.getUrl()&&!mi.getUrl().equals("")){
					json +="\"url:"+mi.getUrl()+"\",";
				}
				if(null!=mi.getTip()&&!mi.getTip().equals("")){
					json +="\"tips:"+mi.getTip()+"\",";
				}
				json = json.substring(0, json.length()-1);
				json +="],";
				json += "\"nodes\":";
				json += getjson(mi.getMenus());
				json += ",";
			}else{
				json += "\"tags\":[";
				boolean flag=false;
				if(null!=mi.getUrl()&&!mi.getUrl().equals("")){
					json +="\"url:"+mi.getUrl()+"\",";
					flag=true;
				}
				if(null!=mi.getTip()&&!mi.getTip().equals("")){
					json +="\"tips:"+mi.getTip()+"\",";
					flag=true;
				}
				if(flag){
					json = json.substring(0, json.length()-1);
				}
				json +="],";
				
			}
			json = json.substring(0, json.length()-1);
			json += "},";
		}
		json = json.substring(0, json.length()-1);
		json += "]";
		return json;
	}
	
	
	/**
	 * 弹出菜单修改页面
	 * @param map
	 * @param mid 菜单id
	 * @return
	 */
	@RequestMapping("/word/openEditPage.do")
	public String editMenuTree(ModelMap map,@RequestParam(value="mid",required=true)Long mid){
		RightEntity menu = menuservice.getMenu(mid);
		map.put("menu", menu);
		map.put("title", menu.getRightText());
		return "views/edit_menu";
	}
	/**
	 * 修改菜单内容
	 * @param map
	 * @param rightEntity
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value="/word/saveMenu.do",method=RequestMethod.POST )
	public void updataaMenuTree(RightEntity rightEntity,HttpServletResponse response) throws IOException{
			response.setCharacterEncoding("utf-8");
		
			try {
				menuservice.updataMenu(rightEntity);
				response.getWriter().write("修改成功");
			} catch (Exception e) {
				response.getWriter().write("修改失败");
			}
	}
	
	/**
	 * 弹出菜单添加页面
	 * @param map
	 * @param mid 菜单id
	 * @return
	 */
	@RequestMapping(value="/word/openAddPage.do",method=RequestMethod.POST )
	public String addMenuTree(ModelMap map,Long mid){
		map.put("pid", mid);
		return "views/add_menu";
	}
	
	/**
	 * 添加菜单内容
	 * @param map
	 * @param rightEntity
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value="/word/addMenu.do",method=RequestMethod.POST )
	public void addMenuTree(RightEntity rightEntity,HttpServletResponse response) throws IOException{
			response.setCharacterEncoding("utf-8");
			try {
				menuservice.insertMenu(rightEntity);
				response.getWriter().write("新增成功");
			} catch (Exception e) {
				response.getWriter().write("新增失败");
			}
	}
	
	/**
	 * 根据level获取menu并返回map的json字符串数据到前台
	 * @param level
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/testurl/getMenu.do",produces = "application/json;charset=utf-8",method={RequestMethod.POST,RequestMethod.GET} )
	public String getMenubyLevel(int level,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		List<RightEntity> list = menuservice.getMenuByLevel(level-1);
		Map<Long, String> map = new HashMap<Long, String>();
 		for(RightEntity r:list){
			map.put(r.getRightCode(), r.getRightText());
		}
		String jsonString = JSONObject.toJSONString(map);
//		System.out.println(jsonString);
		return jsonString;
	}
	/**
	 * 删除menu
	 * @param ids
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value="/testurl/delMenu.do",produces = "application/json;charset=utf-8",method={RequestMethod.POST,RequestMethod.GET} )
	public void delMenubyLevel(String ids,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		String msg = "";
		int i=0;
//		System.out.println(ids);
		String[] split = ids.split("\\|");
		for(int j = 0;j<split.length;j++){
			i += menuservice.delMenuByLevel(Long.parseLong(split[j]));
		}
		if(i==0){
			msg="数据删除失败！";
		}else{
			msg=i+"条数据删除成功！";
		}
//		System.out.println(jsonString);
		response.getWriter().write(msg);
	}
	
	
	
}
