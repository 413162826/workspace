package com.mashen.blog.service;

import com.mashen.blog.model.User;

import java.util.List;

import com.mashen.blog.dao.UserDao;
import com.mashen.blog.service.UserService;

public class UserService {
	private UserService() {};
	
	private static UserService u = new UserService();
	
	public static UserService getInstance() {
		return u;
	}
	
	UserDao dao = UserDao.getInstance();
	
	

}
