package com.oumuv.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAction {

	@RequestMapping("hi")
	private String sayhi() {
		// TODO Auto-generated method stub
		System.out.println("hello word!做点手脚");
		return "login";
	}
	
}
