package com.oumuv.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oumuv.entity.User;

@Controller
public class PageController {
	
	@RequestMapping(value="pageturn.do")
	public String pageResult(@RequestParam("page")String page,HttpServletRequest request,HttpSession session,ModelMap map){
		User user = (User) session.getAttribute("user");
//		map.put("user", user);
		return page;
	}
}
