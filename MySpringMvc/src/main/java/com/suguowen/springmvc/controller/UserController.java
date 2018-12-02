package com.suguowen.springmvc.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.suguowen.springmvc.model.User;
import com.suguowen.springmvc.service.ControllerToService;

@Controller(value="userController")
@RequestMapping("/userController")
public class UserController {
	//测试访问名
	@RequestMapping("/login1")
	public void login1() {
		System.out.println("---进入login1---");
	}
	
	//测试req接收参数
	@RequestMapping("/login2")
	public void login2(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("---进入login2---");
		String username = req.getParameter("username");
		System.out.println("username:"+username);
	}
	
	//测试跳转
	@RequestMapping("/login3")
	public String login3() {
		System.out.println("---进入login3---");
		return "../myHtml/login.html";
	}
	
	//测试重定向
	@RequestMapping("/login4")
	public String login4() {
		System.out.println("---进入login4---");
		return "redirect:../myHtml/login.html";
	}
	
	//测试在当前页面输出值(基本包装类型)
	@RequestMapping("/login5")
	@ResponseBody
	public String login5() {
		System.out.println("---进入login5---");
		return "this is login5";
	}
	
	//测试在当前页面输出值(中文)
	@RequestMapping(value="/login6",produces="text/html;charset=utf-8")
	@ResponseBody
	public String login6() {
		System.out.println("---进入login6---");
		return "this is login6,你好！！";
	}
	
	//测试在当前页面输出值(对象JsonToString)
	@RequestMapping(value="/login7",produces="text/html;charset=utf-8")
	@ResponseBody
	public String login7() {
		User user = new User();
		System.out.println("---进入login7---");
		user.setName("myName");
		user.setPassword("myPassword");
		String jsonUser = JSON.toJSONString(user);
		return jsonUser;
		
	}
	
	//测试在当前页面输出值(对象,导包解决基类问题)
	//responseBody会让页面变成application/json格式
	@RequestMapping(value="/login8",produces="application/json;charset=utf-8")
	@ResponseBody
	public User login8() {
		User user = new User();
		System.out.println("---进入login8---");
		user.setName("myName");
		user.setPassword("myPassword");
		return user;
	}
	
	//ModelAndView之跳转/重定向
	@RequestMapping(value="/login9")
	public ModelAndView login9() {
		System.out.println("---进入login9---");
//		ModelAndView modelAndView = new ModelAndView("../myHtml/login.html");
		ModelAndView modelAndView = new ModelAndView("redirect:../myHtml/login.html");
		return modelAndView;
	}
	
	//ModelAndView之setAttribute
	@RequestMapping(value="/login10")
	public ModelAndView login10() {
		System.out.println("---进入login10---");
		ModelAndView modelAndView = new ModelAndView("../myHtml/login.jsp");
		modelAndView.addObject("userNameFromController","suguowen");
		return modelAndView;
	}
	
	//测试视图解析器简化路径填写
	@RequestMapping(value="/login11")
	public ModelAndView login11() {
		System.out.println("---进入login11---");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("userNameFromController","lzc");
		return modelAndView;
	}
	
	//测试接收参数(基本类型)
	@RequestMapping("/login12")
	public void login12(String username,String password) {
		System.out.println("---进入login12---");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
	}
	
	//测试get/post方法
	@RequestMapping(value="/login13",method= {RequestMethod.POST})
	public void login13(String username,String password) {
		System.out.println("---进入login13---");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
	}
	
	//测试接收参数(对象)
	@RequestMapping("/login14")
	public void login14(User user) {
		System.out.println("---进入login14---");
		System.out.println("username:"+user.getName());
		System.out.println("password:"+user.getPassword());
	}
	
	//测试接收参数(列表)
	@RequestMapping("/login15")
	public void login15(@RequestParam("list1")List list) {
		System.out.println("---进入login15---");
		System.out.println("list:"+list.size());
	}
	
	@Resource(name="controllerToService")
	ControllerToService controllerToService;
	public void test1() {
		controllerToService.controllerToService();	
	}
	
}
//