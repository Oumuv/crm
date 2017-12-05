package com.oumuv.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oumuv.entity.PermissionEntity;
import com.oumuv.service.PermissionService;


@Controller
public class PermissionAction {

	
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 跳转权限管理页面
	 * @return
	 */
	@RequestMapping("/word/PermissionManage.do")
	public String permissionPage(){
		
		return "word/permissionManage";
	}
	
	@RequestMapping("/word/addPermissionPage.do")
	public String addPermissionPage(){
		
		return "views/add_permission";
	}
	@RequestMapping("/word/updataPermissionPage.do")
	public String updataPermissionPage(Long id,ModelMap map){
		PermissionEntity entity = permissionService.getPermissionById(id);
		
		map.put("permission", entity);
		return "views/edit_permission";
	}
	
	
	@RequestMapping("/word/getPermissionByName.do")
	public String getPermissionByName(@RequestParam(value="name",required=false)String name,@RequestParam(value="level",required=false)String level,ModelMap map){
		List<PermissionEntity> list = permissionService.getPermissionListByNameAndLevel(name, level);
		map.put("permissions", list);
		return "views/permission";
	}
	
	@RequestMapping("/word/addPermission.do")
	public void addPermission(PermissionEntity p,ModelMap map,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		int i = permissionService.addPermission(p);
		if(i>0){
			response.getWriter().write("新增成功");
		}else{
			response.getWriter().write("新增失败");
		}
	}
	
	
	
}
