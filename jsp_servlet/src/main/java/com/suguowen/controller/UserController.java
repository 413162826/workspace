package com.suguowen.controller;

import java.util.List;

import com.suguowen.bean.User;
import com.suguowen.service.UserService;

public class UserController {
	private UserService userService = new UserService();
	
	/**
	 * 
	 * @description 查询所有用户信息
	 */
	public void showUserList(){
		//String userList  = userService.selectAllUser();
	}
	public static void main(String[] args) {
		UserController uc = new UserController();
		uc.showUserList();
	}
	
}
