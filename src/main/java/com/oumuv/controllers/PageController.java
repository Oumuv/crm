package com.oumuv.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oumuv.entity.User;

/**
 * 页面控制器
 * 
 * @author Oumuv
 * 
 */
@Controller
public class PageController {

	/**
	 * 页面局部跳转
	 * 
	 * @param page
	 * @param request
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "pageturn")
	public String pageResult(@RequestParam("page") String page,
			HttpServletRequest request, HttpSession session, ModelMap map) {
		User user = (User) session.getAttribute("user");
		map.put("user", user);
		return page;
	}

	/**
	 * 页面弹窗
	 * @param page
	 * @param request
	 * @param session
	 * @param map
	 * @return
	 */

	@RequestMapping(value="dailogturn",method=RequestMethod.POST)
	public String dailogResult(@RequestParam("page") String page,
			HttpServletRequest request, HttpSession session, ModelMap map) {
		User user = (User) session.getAttribute("user");
		map.put("user", user);
		return page;
	}
}
