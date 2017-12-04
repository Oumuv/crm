package com.oumuv.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oumuv.core.info.UserCardInfo;
import com.oumuv.entity.DepartmentEntity;
import com.oumuv.entity.RoleEntity;
import com.oumuv.entity.User;
import com.oumuv.service.DepartmentService;
import com.oumuv.service.RoleService;
import com.oumuv.service.UserService;


/**
 * 用户管理控制器
 * @author Administrator
 *
 */
@Controller
public class UserManageAction {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private DepartmentService departmentService;
	
	
	
	/**
	 * 打开用户管理页面
	 * @return
	 */
	@RequestMapping("/word/Umanager.do")
	public String openUserManage(ModelMap map){
		return "user/usermanage";
	}
	
	/**
	 * 查询用户列表
	 * 名字模糊查询
	 * 部门查询
	 * @param map
	 * @param name
	 * @param did
	 * @return
	 */
	@RequestMapping(value="word/getusercard.do")
	public String getUserList(ModelMap map,@RequestParam(value="name",required=false)String name,@RequestParam(value="id",required=false)Long did){
		List<UserCardInfo> users = userService.getUserCardListByUnameAndDid(name, did);
		map.put("users", users);
		return "views/namecard";
	}
	
	/**
	 * 编辑用户资料页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("word/editUsercardPage.do")
	public String editPage(Long id,ModelMap map){
		User u = new User();
		u.setId(id);
		User user = userService.getPersonInfo(u);
		List<RoleEntity> roleEntitys = roleService.getRoleEntitys(id);
		List<DepartmentEntity> departmenEntitys = departmentService.getAllEntity();		
		
		map.put("user", user);
		map.put("departmens", departmenEntitys);
		map.put("roleEntitys", roleEntitys);
		
		return "views/edit_usercard";
	}
	
	
	@RequestMapping("/word/updataUsercardRole.do")
	public void updataRolePopover(User user,@RequestParam("roles")String roles,ModelMap map,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		String[] split = roles.split(",");
		List<Long> idlist = new ArrayList<Long>();
		for(int j = 0;j<split.length;j++){
			idlist.add(Long.parseLong(split[j]));
		}
		int i = userService.updataUsercardInfo(user,idlist);
		response.getWriter().write("修改成功");
		
	}
	@RequestMapping("word/selectRolePopover.do")
	public String selectRolePopover(@RequestParam("id")Long id,@RequestParam(value="rid",required=false)Long rid,ModelMap map){
		List<RoleEntity> roleEntitys = roleService.getAllRoleEntitys();
		List<RoleEntity> roleselected = roleService.getRoleEntitys(id);
		
		map.put("roleselected", roleselected);
		map.put("rolenoselect", roleEntitys);
		if(null!=rid){
			map.put("rid", rid);
		}
		return "views/selectRolePopover";
	}
}
