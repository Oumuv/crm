package com.oumuv.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oumuv.core.info.DepartmentInfo;
import com.oumuv.entity.DepartmentEntity;
import com.oumuv.entity.User;
import com.oumuv.service.DepartmentService;
import com.oumuv.service.UserService;
import com.oumuv.utils.MyCopyUtil;


/**
 * 部门管理控制器
 * @author Administrator
 *
 */
@Controller
public class DepartmentAction {
	
	@Autowired
	private UserService userService;
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
	/**
	 * 获取所有部门
	 * @param map
	 * @param input
	 * @return
	 */
	@RequestMapping("/word/getDepartmentDetails.do")
	public String getDepartmentDetails(ModelMap map,String input){
		List<DepartmentInfo> list = new ArrayList<DepartmentInfo>();
		if(null!=input&&!input.equals("")){
			List<DepartmentEntity> allEntity = departmentService.getAllEntity(input);
			for(DepartmentEntity d:allEntity){
				List<User> userList = userService.getUserListByUnameAndDid(null, d.getId());
				DepartmentInfo di = new DepartmentInfo();
				MyCopyUtil.copyProp(di, d, new String[]{});
				di.setMenber(userList);
				list.add(di);
			}
		}else{
			List<DepartmentEntity> allEntity = departmentService.getAllEntity();
			for(DepartmentEntity d:allEntity){
				List<User> userList = userService.getUserListByUnameAndDid(null, d.getId());
				DepartmentInfo di = new DepartmentInfo();
				MyCopyUtil.copyProp(di, d, new String[]{});
				di.setMenber(userList);
				list.add(di);
			}
		}
		map.put("list", list);
		return "views/departmentdetail";
	}
	/**
	 * 打开edit页面
	 * @param did
	 * @param map
	 * @return
	 */
	@RequestMapping("/word/editDepartment.do")
	public String edit(Long did,ModelMap map){
		DepartmentEntity entity = departmentService.getEntity(did);
		map.put("info", entity);
		return "views/edit_department";
	}
	/**
	 * 打开add页面
	 * @param map
	 * @return
	 */
	@RequestMapping("/word/addDepartmentPage.do")
	public String addPage(ModelMap map){
		return "views/add_department";
	}
	/**
	 * 保存
	 * @param departmentEntity
	 * @param map
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/word/saveDepartment.do")
	public void save(DepartmentEntity departmentEntity,ModelMap map,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		int i = departmentService.saveEntity(departmentEntity);
		if(i==1){
			response.getWriter().write("修改成功");
		}else{
			response.getWriter().write("修改失败");
		}
	}
	
	/**
	 * 添加
	 * @param departmentEntity
	 * @param map
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/word/addDepartment.do")
	public void add(DepartmentEntity departmentEntity,ModelMap map,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		int i = departmentService.addEntity(departmentEntity);
		if(i==1){
			response.getWriter().write("新增成功");
		}else{
			response.getWriter().write("新增失败");
		}
	}
	/**
	 * 删除
	 * @param id
	 * @param map
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/word/delDepartment.do")
	public void del(Long id,ModelMap map,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		int i;
		try {
			i = departmentService.deleteEntity(id);
			if(i==1){
				response.getWriter().write("删除成功");
			}else{
				response.getWriter().write("删除失败");
			}
		} catch (Exception e) {
			response.getWriter().write("删除失败,需要先删除下属部门");
			e.printStackTrace();
		}
		
	}
	/**
	 * 获取可选的上级部门list 并返回html
	 * @param map
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/word/getParent.do")
	public void getParentList(ModelMap map,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		List<DepartmentEntity> list = departmentService.getAllEntity();
		String html = "";
		for(DepartmentEntity d:list){
			if(null==d.getPid()&&d.getId()==1){
				html += "<option value='"+d.getId()+"' selected='selected'>"+d.getName()+"</option>";
			}else{
				html += "<option value='"+d.getId()+"'>"+d.getName()+"</option>";
			}
		}
			response.getWriter().write(html);
	}
	
}
