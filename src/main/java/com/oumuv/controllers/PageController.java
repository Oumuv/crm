package com.oumuv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping(value="pageturn.do",method=RequestMethod.GET)
	public String pageResult(@RequestParam("page")String page){
		System.out.println(page+"页面");
		return page;
	}
}
