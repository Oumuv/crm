package com.oumuv.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oumuv.entity.User;
import com.oumuv.service.UserService;


/**
 * 部门管理控制器
 * @author Administrator
 *
 */
@Controller
public class DepartmentAction {
	
	
	/**
	 * 打开部门管理页面
	 * @return
	 */
	@RequestMapping("/word/departmentManage.do")
	public String openUserManage(ModelMap map){
		return "word/departmentmanage";
	}
	
}
