package com.mashen.myblog.servlet;

import java.io.IOException;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

import com.mashen.myblog.service.UserService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	UserService u = UserService.getInstance();//单例

	// 登陆方法
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 数据接收
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		// 操作数据库
		Map map = u.doLogin(userName, password);
		resp.setContentType("text/html;charset=	utf-8");
		if (map.get("flag").equals(-1)) {
			resp.getWriter().println("用户不存在");
		} else if (map.get("flag").equals(2)) {
			resp.getWriter().println("密码错误");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", map.get("user"));
			resp.sendRedirect("index.html");
		}

		// 响应
	}

}
