package com.suguowen.avg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/info")
public class PersonInfo {
	
	//显示角色信息
	@RequestMapping("/info")
	@ResponseBody
	public String personInfo() {
		return "hello";
	}
	
	/*
	 * Adapter和ViewResolver
	 */
	@RequestMapping("/servlet1")
	public ModelAndView servlet1() {
		ModelAndView modelAndView = new ModelAndView("user");
		modelAndView.addObject("name", "suguowen");
		modelAndView.addObject("password", "123456");
		return modelAndView;
		
	}
	
	
}
