package com.oumuv.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oumuv.entity.DepartmentEntity;
import com.oumuv.entity.User;
import com.oumuv.service.DepartmentService;
import com.oumuv.service.UserService;


/**
 * 部门管理控制器
 * @author Administrator
 *
 */
@Controller
public class DepartmentAction {
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 打开部门管理页面
	 * @return
	 */
	@RequestMapping("/word/departmentManage.do")
	public String opendepartmentManage(ModelMap map){
		return "word/departmentmanage";
	}
	
	/**
	 * 获取部门列表的下拉选框option
	 * @return HTML
	 */
	@ResponseBody
	@RequestMapping(value = "/word/getAllDepartment.do",produces="application/text;charset=utf-8")
	public String getAllDepartment(){
		List<DepartmentEntity> list = departmentService.getAllEntity();
		String html = "<option value='' >所有部门</option>"	;
		for(DepartmentEntity d:list){
			html += "<option value='"+d.getId()+"'>"+d.getName()+"</option>";
		}
		return html;
		
	}
	
}
