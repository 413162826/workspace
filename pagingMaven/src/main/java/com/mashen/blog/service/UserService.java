package com.mashen.blog.service;

import com.mashen.blog.model.PageBean;
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
	
	
	public PageBean findAllUserByPage(int currentPage,int pageSize) {
		List<User> ulist = dao.findAllUser();
		int totalRecord = ulist.size();
		PageBean pb = new PageBean(currentPage, pageSize, totalRecord);
		pb.setUlist(ulist);//保存ulist
//		System.out.println(ulist.get(1).getUserName());
		return pb;
	}
}
