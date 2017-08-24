package com.oumuv.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAction {

	@RequestMapping("/login")
	private String sayhi(String username,String password) {
		// TODO Auto-generated method stub
		System.out.println("hello "+ username +"!");
		return "index";
	}
	
}
