package com.oumuv.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oumuv.entity.LoginRecordEntity;
import com.oumuv.entity.User;
import com.oumuv.service.LoginRecordService;
import com.oumuv.service.UserService;
import com.oumuv.utils.MD5Util;

/**
 * @author Administrator
 *user控制层
 */
@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource
	private UserService userService;
	@Autowired
	private LoginRecordService loginRecordService;
	
	@RequestMapping("/login.do")
	public String login(@Param(value="usename") String username,@Param("password") String password,ModelMap map,HttpSession session) {
		User user = userService.login(username, MD5Util.GetMD5Code(password));
		if(user==null){
			map.clear();
			map.put("username", username);
			map.put("msg1", "密码错误，请重新输入");
			return "forward:/login.jsp";
		}else if(user.getUsername().equals(username)&&user.getPassword().equals(MD5Util.GetMD5Code(password))){
			map.clear();
			map.put("user",user);
			session.setAttribute("user", user);
			LoginRecordEntity record =new LoginRecordEntity();//保存登录记录
			record.setUserId(user.getId());
//			String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			Timestamp Timestamp=new Timestamp(new Date().getTime());
			record.setLoginDate(Timestamp);
			loginRecordService.loginRecored(record);
			return "index";
		}
		return "forward:/login.jsp";
	}

	
	@RequestMapping("/check.do")
	public void check(String username,HttpServletRequest request,HttpServletResponse response,ModelMap map) throws IOException {
		String user = userService.check(username);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(username.equals("")){
			response.getWriter().write("请输入用户名");
		}else if(user==null){
			response.getWriter().write("用户不存在");
		}
	}
	
	@RequestMapping("/logout.do")
	public String check(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		session.removeAttribute("user");
		return "redirect:/login.jsp";
	}


	
}
