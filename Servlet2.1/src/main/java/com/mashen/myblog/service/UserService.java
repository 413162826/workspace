package com.mashen.myblog.service;

import java.util.HashMap;
import java.util.Map;

import com.mashen.myblog.dao.UserDao;
import com.mashen.myblog.model.User;

public class UserService {
	
	private UserService(){}
	
	private static UserService userService = new UserService();
	
	public static UserService getInstance() {
		return userService;//单例模式，限制其他人使用new浪费内存
	}
	
	
	UserDao dao= UserDao.getInstance();
	
	public Map doLogin(String userName,String password) {
		Map map = new HashMap();
		User u = dao.getUserByName(userName);
		if (u==null) {
			//账号名不存在
			map.put("flag", -1);
		}else {
			//判断密码
			if (u.getPassword().equals(password)) {
				//密码正确
				map.put("flag",1);
				map.put("user",u);
			}else {
				//密码错误
				map.put("flag", 2); 
			}
		}
		return map;
	}
}
