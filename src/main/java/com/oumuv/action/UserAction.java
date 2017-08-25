package com.oumuv.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 *user控制层
 */
@Controller
@RequestMapping("/user")
public class UserAction {

	@RequestMapping("/login.do")
	public String login(String username,String password,ModelMap map,HttpSession session) {
		if(username.equals("123")&&password.equals("123")){
			map.clear();
			map.put("user", username);
			session.setAttribute("user", username);
			return "index";
		}else{
			map.clear();
			map.put("username", username);
			map.put("msg1", "密码错误，请重新输入");
			return "forward:/login.jsp";
		}
	}

	
	@RequestMapping("/check.do")
	public void check(String username,HttpServletRequest request,HttpServletResponse response,ModelMap map) throws IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(username.equals("")){
			response.getWriter().write("请输入用户名");
		}else if(!username.equals("123")){
			response.getWriter().write("用户不存在");
		}
	}
	
	@RequestMapping("/logout.do")
	public String check(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		session.removeAttribute("user");
		return "redirect:/login.jsp";
	}
	
}
