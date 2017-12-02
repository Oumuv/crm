package com.oumuv.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oumuv.core.info.RoleInfo;
import com.oumuv.entity.PermissionEntity;
import com.oumuv.entity.RightEntity;
import com.oumuv.entity.RoleEntity;
import com.oumuv.service.MenuService;
import com.oumuv.service.PermissionService;
import com.oumuv.service.RoleService;

@Controller
public class RoleAction {

	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private PermissionService permissionService;
	
	
	/***
	 * role管理页面
	 * @return
	 */
	@RequestMapping("/word/roleManage.do")
	public String roleManage(){
		return "word/rolemanage";
	}
	
	/**
	 * 搜索获取role
	 * @param name
	 * @param map
	 * @return
	 */
	@RequestMapping("/word/getRoleByName.do")
	public String getRoleByName(String name,ModelMap map){
		if(null==name){
			name=new String("");
		}
		 List<RoleInfo> list = roleService.findRoleByInputResult(name);
		 for(RoleInfo r:list){
			 int i = 0;
			 int j = 0;
			 if(i<=1) if(r.getmCount()>0){
				 List<String> menuNameListByRid = menuService.getMenuNameListByRid(r.getRoleId());
				 r.setMenus(menuNameListByRid);
				 i++;
			 }
			 if(j<=1) if(r.getpCount()>0){
				 List<String> permissionNameListByRid = permissionService.getPermissionNameListByRid(r.getRoleId());
				 r.setPermissions(permissionNameListByRid);
				 j++;
			 }
		 }
		map.put("roles", list);
		return "views/role";
	}
	
	/***
	 * 添加页面
	 * @return
	 */
	@RequestMapping("/word/addRolePage.do")
	public String addRolePage(){
		
		return "views/add_role";
	}
	/***
	 * 添加页面
	 * @return
	 */
	@RequestMapping("/word/updataRolePage.do")
	public String updataRolePage(ModelMap map,Long id){
		RoleEntity role = roleService.getRole(id);
		List<RightEntity> allMenus = menuService.getAllMenus();
		List<RightEntity> menuListByRid = menuService.getMenuListByRid(id);
		List<PermissionEntity> allPermission = permissionService.getAllPermission();
		List<PermissionEntity> permissionsByRid = permissionService.getPermissionListByRid(id);
		map.put("allMenus", allMenus);
		map.put("allPermission", allPermission);
		map.put("menus", menuListByRid);
		map.put("permissions", permissionsByRid);
		map.put("role", role);
		return "views/edit_role";
	}
	
	@RequestMapping("/word/addRole.do")
	public void addRole(RoleEntity roleEntiy,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		int i = roleService.addRole(roleEntiy);
		if(i>0){
			response.getWriter().write("添加成功");
		}else{
			response.getWriter().write("添加失败");
		}
	}
	@RequestMapping("/word/delRole.do")
	public void delRole(Long id,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		int i = roleService.deleteRole(id);
		if(i>0){
			response.getWriter().write("删除成功");
		}else{
			response.getWriter().write("删除失败，该角色正在被使用");
		}
	}
	@RequestMapping("/word/updataRole.do")
	public void updataRole(RoleEntity roleEntity,@RequestParam(value="menus",required=false)List<Long> menus,@RequestParam(value="permissions",required=false)List<Long> permissions,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		int i = roleService.updataRole(roleEntity,menus,permissions);
		if(i>0){
			response.getWriter().write("修改成功,1分钟之后生效！");
		}else{
			response.getWriter().write("修改失败");
		}
	}
	
}
