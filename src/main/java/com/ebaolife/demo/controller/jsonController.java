package com.ebaolife.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebaolife.demo.model.User;

	//返回JSON对象
@Controller
@RequestMapping("/json")
public class jsonController {
	@ResponseBody
	@RequestMapping("/user")
	public User getJSON(){
		User u = new User();
		u.setId(1);
		u.setName("reus");
		u.setBirth(new Date());
		return u;
	}
	//返回字符串到页面
	@ResponseBody
	@RequestMapping("/string")
	public String getString(){
		User u = new User();
		u.setId(1);
		u.setName("reus");
		u.setBirth(new Date());
		return u.toString();
	}
}
