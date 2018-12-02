package com.suguowen.blog.service;

public class LoginService {
	//login功能
	public int isUser(String userName,String password) {
		if(userName.equals("suguowen")) {
			//匹配密码
			if (password.equals("123")) {
				//发送邮件，省略验证邮件拼写问题，可以在jsp验证
				return 1;
			}else {
				//密码不正确
				return -2;
			}
		}else {
			//账户不正确
			return -1;
		}
	}
}
