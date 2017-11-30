package com.oumuv.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oumuv.core.info.RoleInfo;
import com.oumuv.entity.RoleEntity;
import com.oumuv.service.RoleService;
import com.oumuv.utils.MyCopyUtil;

@Controller
public class RoleAction {

	@Autowired
	private RoleService roleService;
	
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
		List<RoleEntity> list = roleService.getRoleByInput(name);
		List<RoleInfo> rList = new ArrayList<RoleInfo>();
		for(RoleEntity r:list){
			RoleInfo role = new RoleInfo();
			MyCopyUtil.copyProp(role, r, new String []{});
			rList.add(role);
		}
		map.put("roles", rList);
		return "word/rolemanage";
	}
	
}
